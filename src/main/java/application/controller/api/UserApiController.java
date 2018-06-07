package application.controller.api;

import application.data.model.User;
import application.model.BaseApiResult;
import application.model.DataApiResult;
import application.model.UserDetailModel;
import application.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    UserService userService;

    @GetMapping("/img/{userName}")
    public BaseApiResult getImg(@PathVariable String userName){
        DataApiResult result = new DataApiResult();

        try {
            result.setSuccess(true);
            result.setData(userService.getImage(userName));
            result.setMessage("success");
        } catch (Exception e) {
            result.setData("");
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
            result.setMessage("success");
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
    public BaseApiResult updateUser (@PathVariable int id,
                                     @RequestBody UserDetailModel user){

        DataApiResult result = new DataApiResult();
        try {
            if(!"".equals(user.getUsername()) && !"".equals(user.getFullname())
                    && !"".equals(user.getEmail())) {
                User existUser = userService.findOne(id);
                if(existUser== null) {
                    result.setSuccess(false);
                    result.setMessage("Invalid model");
                } else {
                    existUser.setUsername(user.getUsername());
                    existUser.setFullname(user.getFullname());
                    existUser.setGender(user.getGender());
                    existUser.setAddress(user.getAddress());
                    existUser.setEmail(user.getEmail());
                    existUser.setImageurl(user.getImageurl());
                    existUser.setUpdatedDate(user.getUpdatedDate());
                    userService.updateUser(existUser);
                    result.setSuccess(true);
                    result.setMessage("Update user successfully");
                }
            } else {
                result.setSuccess(false);
                result.setMessage("Invalid model");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }


        return result;
    }
}
