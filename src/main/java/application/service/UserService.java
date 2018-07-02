package application.service;

import application.constant.RoleIdConstant;
import application.constant.StatusRegisterUserEnum;
import application.constant.StatusRoleConstant;
import application.data.model.Role;
import application.data.model.User;
import application.data.model.UserRole;
import application.data.repository.IRoleRepository;
import application.data.repository.IUserRepository;
import application.data.repository.IUserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public StatusRegisterUserEnum registerNewUser(User user) {
        logger.info("Start registerNewUser");
        try {
            // check existed user
            if(findUserByUsername(user.getUsername()) != null) {
                return StatusRegisterUserEnum.Existed_Username;
            }

            if(findUserByEmail(user.getEmail()) != null) {
                return StatusRegisterUserEnum.Existed_Email;
            }

            // hash pass
            user.setPasswordHashed(passwordEncoder.encode(user.getPassword()));
            user.setCreatedDate(new Date());
            user.setUpdatedDate(new Date());
            user.setAddress(user.getAddress());
            user.setGender("Male");
            if(user.getImageurl() == null){
                user.setImageurl("/link/1528177697-default-user.png");
            }else{
                user.setImageurl(user.getImageurl());
            }

            // save user
            userRepository.save(user);

            // insert new role
            UserRole userRole = new UserRole();
            userRole.setRoleId(RoleIdConstant.Role_User);
            userRole.setUserId(user.getId());
            userRole.setStatus(StatusRoleConstant.ActiveStatus);

            userRoleRepository.save(userRole);

            return StatusRegisterUserEnum.Success;
        } catch (Exception ex) {
            logger.info("Exception on registerNewUser: " + ex.getMessage());
            return StatusRegisterUserEnum.Error_OnSystem;
        }
    }

    public String getImage(String username){
        return userRepository.getImgByUserName(username);
    }

    public User findOne(int id){
        return userRepository.findOne(id);
    }

    public String findIdByUsername(String username){
        User user = userRepository.findUserByUsername(username);
        return user.getId();
    }

    public boolean updateUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }


    public List<Role> getListRole() {
        return StreamSupport
                .stream(roleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

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

    public List<Role> getActiveListRole(String userId) {
        List<UserRole> listUserRoles = StreamSupport
                .stream(userRoleRepository.findRolesOfUser(userId).spliterator(), false).filter(
                        userRole -> userRole.getStatus() == StatusRoleConstant.ActiveStatus
                ).collect(Collectors.toList());

        return getListRole().stream().filter(role -> {
            return (listUserRoles.stream().filter(userRole -> userRole.getRoleId() == role.getId()).findFirst().orElse(null) != null);
        }).collect(Collectors.toList());
    }

//    public String findRolesOfUser(String userid){
//        ModelMapper modelMapper = new ModelMapper();
//        UserRoleModel userRoleModel = modelMapper.map(userRoleRepository.findRolesOfUser(userid),UserRoleModel.class);
//        return roleRepository.getRole(userRoleModel.getUserid());
//    }

    public String findRoleName(String userId){
        return roleRepository.findRoleById(userRoleRepository.findRoleIdByUserId(userId).getRoleId()).getRoleName();
    }

    public ArrayList<UserRole> getUserRole(){
        return userRoleRepository.getUserRole();
    }

    public User findUserById(String id){
        return userRepository.findUserById(id);
    }

    public Role findRoleById(int id){
        return roleRepository.findRoleById(id);
    }

    public UserRole findUserRole(String id){
        return userRoleRepository.findRoleIdByUserId(id);
    }

    public boolean updateRole(String userId){
        try {
            UserRole userRole = new UserRole();
            userRole = userRoleRepository.findRoleIdByUserId(userId);
            if(userRole.getRoleId() == RoleIdConstant.Role_Admin){
                userRole.setRoleId(RoleIdConstant.Role_User);
            }else if(userRole.getRoleId() == RoleIdConstant.Role_User){
                userRole.setRoleId(RoleIdConstant.Role_Admin);
            }
            userRoleRepository.save(userRole);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }
}

