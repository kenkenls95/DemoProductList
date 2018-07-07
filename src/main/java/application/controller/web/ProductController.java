package application.controller.web;

import application.data.model.Order;
import application.data.model.Product;
import application.data.model.User;
import application.data.service.CategoryService;
import application.data.service.OrderService;
import application.data.service.ProductService;
import application.model.ProductDetailModel;
import application.model.ProductName;
import application.service.UserService;
import application.viewmodel.productindex.ProductSearchVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping(path="/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/detail/{productId}")
    public String index(Model model, @PathVariable int productId) {
        Product existProduct = productService.findOne(productId);
        if(existProduct != null) {
            ModelMapper modelMapper = new ModelMapper();
            ProductDetailModel productDetailModel = modelMapper.map(existProduct, ProductDetailModel.class);

            model.addAttribute("vm", productDetailModel);
            return "product/index";
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchProduct(@ModelAttribute ProductName productName, BindingResult errors, Model model) {
        ModelMapper modelMapper = new ModelMapper();
        ProductSearchVM productSearchVM = new ProductSearchVM();
        try {
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<ProductDetailModel> productDetailModels = new ArrayList<>();
            products =  productService.findByNameContaining(productName.getName());
            for(Product p : products){
                productDetailModels.add(modelMapper.map(p,ProductDetailModel.class));
            }
            productSearchVM.setKeyWord(productName.getName());
            productSearchVM.setProductDetailModels(productDetailModels);
            model.addAttribute("vm",productSearchVM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product/search";
    }

    @GetMapping("/order/checkout")
    public String checkout(Model model,
                           HttpServletResponse response,
                           HttpServletRequest request,
                           final Principal principal){

        Cookie cookies[] = request.getCookies();
        UUID uuid = UUID.randomUUID();
        String guid = uuid.toString();
        String user_guild = "";

        if (cookies != null) {
            for(Cookie c : cookies){
                if(c.getName().equals("User_Guild")){
                    if(c.getValue() != null){
                        user_guild = c.getValue();
                    }
                }
            }
        }

        try {
            Order order = orderService.findOrderByUserguild(user_guild);
            if(check(order.getUserid())){
                model.addAttribute("user" , new User());
            }else {
                User existUser = userService.findUserById(order.getUserid());
                model.addAttribute("user" , existUser);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return "checkout";
    }

    public boolean check(String id){
        if (id == null)
            return true;
        else if (id.trim().equals(""))
            return true;
        else
            return false;
    }

}
