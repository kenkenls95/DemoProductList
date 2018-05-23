package application.controller.web;

import application.data.model.Category;
import application.data.model.Product;
import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.model.CategoryProductModel;
import application.model.ProductDetailModel;
import application.model.ProductName;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


/**
 * Created by ManhNguyen on 1/30/18.
 */

@Controller
@RequestMapping(path="/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/detail/{productId}")
    public String index(Model model, @PathVariable int productId,
                        @CookieValue(value = "current-page", defaultValue = "")
                                String currentPageCookie) {

        System.out.println("-----------------------------------------");
        System.out.println(currentPageCookie);


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

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchProduct(@ModelAttribute ProductName productName, BindingResult errors, Model model) {
        try {
            Object existProduct =  productService.findByName(productName.getName());
            ModelMapper modelMapper = new ModelMapper();
            ProductDetailModel productDetailModel = modelMapper.map(existProduct, ProductDetailModel.class);
            model.addAttribute("vm",productDetailModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product/index";
    }

}
