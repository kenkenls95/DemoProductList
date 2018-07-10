package application.controller.api;

import application.data.model.User;
import application.data.model.UserRole;
import application.data.service.OrderService;
import application.model.*;
import application.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    OrderService orderService;

    @GetMapping("/detail/{userId}")
    public BaseApiResult getUser(@PathVariable String userId){
        DataApiResult result = new DataApiResult();
        try {
            User user = userService.findUserById(userId);
            result.setData(user);
            result.setSuccess(true);
            result.setMessage("success");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setData(null);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping("/alluser")
    public BaseApiResult getUserRole(){
        DataApiResult result = new DataApiResult();
        try {
            ArrayList<UserRole> userRoles = new ArrayList<>();
            ArrayList<UserRoleDataModel> userRoleDataModels = new ArrayList<>();
            userRoles = userService.getUserRole();
            for(UserRole u : userRoles){
                userRoleDataModels.add(new UserRoleDataModel(u.getId(),userService.findUserById(u.getUserId()),userService.findRoleById(u.getRoleId())));
            }
            result.setData(userRoleDataModels);
            result.setMessage("success");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setData(null);
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/update-role/")
    public BaseApiResult updateRole(@RequestBody UserDataModel userDataModel){
        DataApiResult result = new DataApiResult();
        try {
            if(userService.updateRole(userDataModel.getUserId())){
                result.setMessage("success");
                result.setSuccess(true);
                result.setData(null);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            result.setData(null);
        }

        return result;
    }


    @GetMapping("/img/{userName}")
    public BaseApiResult getImg(@PathVariable String userName){
        DataApiResult result = new DataApiResult();
        ModelMapper modelMapper = new ModelMapper();
        try {
            User user = userService.findUserByUsername(userName);
            UserImageModel userImageModel = modelMapper.map(user,UserImageModel.class);
            result.setData(userImageModel);
            result.setSuccess(true);
            result.setMessage("success");
        } catch (Exception e) {
            result.setData(null);
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping("/{username}")
    public BaseApiResult getProfile(@PathVariable String username){
        DataApiResult result = new DataApiResult();
        ModelMapper modelMapper = new ModelMapper();
        try {
            UserDetailModel u = new UserDetailModel();
            u = modelMapper.map(userService.findUserByUsername(username),UserDetailModel.class);

            result.setMessage(userService.findRoleName(u.getId()));

            result.setData(u);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setData(null);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/update-user/{id}")
    public BaseApiResult updateUser (@PathVariable String id,
                                     @RequestBody UserDetailModel user){

        DataApiResult result = new DataApiResult();
        try {
            if(!"".equals(user.getUsername()) && !"".equals(user.getFullname())
                    && !"".equals(user.getEmail())) {
                User existUser = userService.findUserById(id);
                if(existUser == null) {
                    result.setSuccess(false);
                    result.setMessage("Invalid model");
                } else if (passwordEncoder.matches(user.getOldpassword(),existUser.getPasswordHashed())) {
                        existUser.setUsername(user.getUsername());
                        existUser.setFullname(user.getFullname());
                        existUser.setGender(user.getGender());
                        existUser.setAddress(user.getAddress());
                        existUser.setEmail(user.getEmail());
                        existUser.setPhone(user.getPhone());
                        existUser.setImageurl(user.getImageurl());
                        existUser.setUpdatedDate(user.getUpdatedDate());
                        existUser.setPasswordHashed(passwordEncoder.encode(user.getPassword()));
                        userService.updateUser(existUser);
                        result.setSuccess(true);
                        result.setMessage("Update user successfully");
                } else if("".equals(user.getOldpassword()) && "".equals(user.getPassword())){
                    existUser.setUsername(user.getUsername());
                    existUser.setFullname(user.getFullname());
                    existUser.setGender(user.getGender());
                    existUser.setAddress(user.getAddress());
                    existUser.setEmail(user.getEmail());
                    existUser.setPhone(user.getPhone());
                    existUser.setImageurl(user.getImageurl());
                    existUser.setUpdatedDate(user.getUpdatedDate());
                    userService.updateUser(existUser);
                    result.setSuccess(true);
                    result.setMessage("Update user successfully");
                }else {
                    result.setSuccess(false);
                    result.setMessage("Wrong password");
                }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/disable/{userId}")
    public BaseApiResult disableUser(@PathVariable String userId){
        DataApiResult result = new DataApiResult();

        return result;
    }
}
