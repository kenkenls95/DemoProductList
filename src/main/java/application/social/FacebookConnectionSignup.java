package application.social;

import application.constant.RoleIdConstant;
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

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        user.setUsername(connection.getDisplayName());
        user.setPassword(randomAlphabetic(8));
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setRoleId(RoleIdConstant.Role_User);
        userRole.setUserId(user.getId());
        userRole.setStatus(StatusRoleConstant.ActiveStatus);

        userRoleRepository.save(userRole);
        return user.getUsername();
    }
}
