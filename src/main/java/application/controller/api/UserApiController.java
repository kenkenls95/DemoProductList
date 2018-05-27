package application.controller.api;

import application.model.BaseApiResult;
import application.model.DataApiResult;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
