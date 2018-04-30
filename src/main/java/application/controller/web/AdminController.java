package application.controller.web;


import application.constant.Constant;
import application.data.model.Category;
import application.data.model.PaginableItemList;
import application.data.model.Product;
import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.model.CategoryDataModel;
import application.viewmodel.admin.AdminVM;
import application.viewmodel.common.ProductVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/")
public class AdminController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    //@GetMapping(path="admin")
    @RequestMapping(path = "admin", method = RequestMethod.GET)
    public String admin(Model model, @RequestParam(value="pageNumber", required=false) Integer pageNumber) {

        int pageSize = Constant.DEFAULT_PAGE_SIZE;

        AdminVM vm = new AdminVM();
        long totalProducts = productService.getTotalProducts();

        vm.setMessageTotalProducts("Total existed products: " + totalProducts);

        if(pageNumber == null) {
            pageNumber = 1;
        }

        try {
            PaginableItemList<Product> paginableItemList = productService.getListProducts(Constant.DEFAULT_PAGE_SIZE,
                    pageNumber - 1);

            List<Product> listProducts = paginableItemList.getListData();
            ArrayList<ProductVM> listProductVMs = new ArrayList<>();
            ModelMapper modelMapper = new ModelMapper();
            for(Product product : listProducts) {
                ProductVM productVM = modelMapper.map(product, ProductVM.class);
                listProductVMs.add(productVM);
            }
            vm.setListPagingProducts(listProductVMs);

            int totalPages = 0;
            if(paginableItemList.getTotalProducts() % pageSize == 0) {
                totalPages = (int)(paginableItemList.getTotalProducts() / pageSize);
            } else {
                totalPages = (int)(paginableItemList.getTotalProducts() / pageSize) + 1;
            }

            vm.setTotalPagingItems(totalPages);
            vm.setCurrentPage(pageNumber);

            //TODO: get list categories
            List<Category> listCategories = categoryService.getListAllCategories();
            ArrayList<CategoryDataModel> dataModelArrayList = new ArrayList<>();
            for (Category cat :
                    listCategories) {
                dataModelArrayList.add(modelMapper.map(cat, CategoryDataModel.class));
            }
            vm.setListCategories(dataModelArrayList);

        } catch (Exception e) {

        }

        model.addAttribute("vm", vm);

        return "admin";
    }
}
