package application.controller.web;

import application.constant.StatusOrderConstant;
import application.constant.StatusRegisterUserEnum;
import application.data.model.Order;
import application.data.model.User;
import application.data.service.OrderService;
import application.model.OrderModel;
import application.service.UserService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class UserController{

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping(path="/register-user")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    @RequestMapping(path="/register-user", method = RequestMethod.POST)
    public String registerNewUser(@Valid @ModelAttribute("user")User user,
                                  BindingResult result){

        logger.info("registerNewUser: " + new Gson().toJson(user));

        StatusRegisterUserEnum statusRegisterUserEnum = userService.registerNewUser(user);
        logger.info(statusRegisterUserEnum.toString());
        return "redirect:/";
    }

    @GetMapping("/user")
    public String user(Model model,
                       HttpServletResponse response,
                       @RequestHeader("User-Agent") String userAgent,
                       HttpServletRequest request,
                       final Principal principal){
        ModelMapper modelMapper = new ModelMapper();
        try {
            if(principal != null){
                User user = userService.findUserByUsername(principal.getName());
                Order order = orderService.findOrderByUserIdAndStatusid(user.getId(),StatusOrderConstant.unpaid);
                response.addCookie(new Cookie("OrderId", Integer.toString(order.getId())));
                response.addCookie(new Cookie("User_Id",user.getId()));
                response.addCookie(new Cookie("User_Guild",order.getUserguild()));
                ArrayList<Object> objects = new ArrayList<>();
                ArrayList<OrderModel> orderModels = new ArrayList<>();
                objects = orderService.getOrderByUser(user.getId());
                for(Object o : objects){
                    orderModels.add(modelMapper.map(o,OrderModel.class));
                }
                ArrayList<OrderModel> orderModels1 = new ArrayList<>();
                for(OrderModel o : orderModels){
                    if(o.getOrderStatus().getId() != 3 && o.getOrderStatus().getId() != 4){
                        orderModels1.add(o);
                    }
                }
                if(orderModels1.size() > 0){
                    model.addAttribute("vm",orderModels1);
                }else {
                    model.addAttribute("vm",null);
                }
            }else {

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        return "/user";
    }

}
