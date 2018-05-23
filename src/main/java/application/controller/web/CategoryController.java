package application.controller.web;

import application.data.model.Category;
import application.data.service.CategoryService;
import application.model.CategoryProductModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/detail/{catId}")
    public String getListCategory(Model model, @PathVariable int catId,
                                  @CookieValue(value = "current-page", defaultValue = "")
                                          String currentPageCookie) {

        System.out.println("-----------------------------------------");
        System.out.println(currentPageCookie);

        Category existCat = categoryService.findById(catId);

        try {
            ModelMapper modelMapper = new ModelMapper();
            CategoryProductModel categoryProductModel = modelMapper.map(existCat, CategoryProductModel.class);
            model.addAttribute("vm", categoryProductModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list_bycategory";
    }
}
