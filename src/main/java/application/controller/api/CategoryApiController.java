package application.controller.api;

import application.data.model.Category;
import application.data.model.Product;
import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/allcat")
    public BaseApiResult fillAll(){
        DataApiResult result = new DataApiResult();
        ModelMapper modelMapper = new ModelMapper();
        try {
            List<Category> categoryList = categoryService.fillAll();
            ArrayList<CategoryDetailModel> categoryDetailModelArrayList = new ArrayList<>();
            for(Category cat : categoryList){
                categoryDetailModelArrayList.add(modelMapper.map(cat, CategoryDetailModel.class));
            }
            result.setMessage("success");
            result.setData(categoryDetailModelArrayList);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setData(null);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping("/getcat")
    public BaseApiResult getCat(){
        DataApiResult result = new DataApiResult();

        try {
            result.setData(getCategories());
            result.setMessage("success");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setData(null);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }

        return result;
    }

    @GetMapping("/detail/{catId}")
    public BaseApiResult getListCategory(@PathVariable int catId) {
        DataApiResult result = new DataApiResult();
        Category existCat = categoryService.findById(catId);

        try {
            ModelMapper modelMapper = new ModelMapper();
            CategoryProductModel categoryProductModel = modelMapper.map(existCat, CategoryProductModel.class);
            result.setMessage("success");
            result.setData(categoryProductModel);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setData(null);
            result.setSuccess(false);
        }
        return result;
    }

    public ArrayList<CategoryInfor> getCategories(){
        ModelMapper modelMapper = new ModelMapper();
        ArrayList<CategoryInfor> categoryInforArrayList = new ArrayList<>();
        try {
            List<Category> categoryList = categoryService.fillAll();
            ArrayList<CategoryDetailModel> categoryDetailModelArrayList = new ArrayList<>();
            for(Category cat : categoryList){
                categoryDetailModelArrayList.add(modelMapper.map(cat,CategoryDetailModel.class));
            }
            for (CategoryDetailModel cat : categoryDetailModelArrayList){
                CategoryInfor categoryInfor = new CategoryInfor();
                if(getChil(cat.getId()).size() > 0 && cat.getParentid() == 0){
                    categoryInfor.setCategories(getChil(cat.getId()));
                    categoryInfor.setParentname(cat.getName());
                    categoryInfor.setParentid(cat.getId());
                    categoryInforArrayList.add(categoryInfor);
                }else if(getChil(cat.getId()).size() == 0 && cat.getParentid() == 0) {
                    categoryInfor.setCategories(null);
                    categoryInfor.setParentname(cat.getName());
                    categoryInfor.setParentid(cat.getId());
                    categoryInforArrayList.add(categoryInfor);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryInforArrayList;
    }

    public ArrayList<CategoryDetailModel> getChil(int id){
        List<Object[]> list = categoryService.findByParentid(id);
        ModelMapper modelMapper = new ModelMapper();
        ArrayList<CategoryDetailModel> categoryDetailModels = new ArrayList<>();
        for(Object cat : list){
            categoryDetailModels.add(modelMapper.map(cat,CategoryDetailModel.class));
        }
        return categoryDetailModels;
    }
}
