package application.social;

import application.constant.RoleIdConstant;
import application.constant.StatusRegisterUserEnum;
import application.constant.StatusRoleConstant;
import application.data.model.User;
import application.data.model.UserRole;
import application.data.repository.IUserRepository;
import application.data.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.StreamSupport;


@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        try {
            if(findUserByUsername(connection.getDisplayName()) != null) {
                return connection.getDisplayName();
            }else {

                user.setUsername(connection.getDisplayName());
                user.setPassword(null);
                user.setCreatedDate(new Date());
                user.setUpdatedDate(null);
                user.setImageurl(connection.getImageUrl());
                userRepository.save(user);
                UserRole userRole = new UserRole();
                userRole.setRoleId(RoleIdConstant.Role_User);
                userRole.setUserId(user.getId());
                userRole.setStatus(StatusRoleConstant.ActiveStatus);

                userRoleRepository.save(userRole);
            }
            return user.getUsername();
        } catch (Exception e) {
            return connection.getDisplayName();
        }
    }

    public User findUserByEmail(String email) {
        return StreamSupport
                .stream(userRepository.findByEmail(email).spliterator(), false)
                .findFirst().orElse(null);
    }

    public User findUserByUsername(String username) {
        return StreamSupport
                .stream(userRepository.findByUsername(username).spliterator(), false)
                .findFirst().orElse(null);
    }
}
