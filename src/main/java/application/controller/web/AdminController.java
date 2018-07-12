package application.controller.web;


import application.data.model.Category;
import application.data.model.Order;
import application.data.model.Product;
import application.data.service.CategoryService;
import application.data.service.OrderService;
import application.data.service.ProductService;
import application.model.CategoryDataModel;
import application.model.OrderDetailModel;
import application.service.UserService;
import application.viewmodel.admin.AdminVM;
import application.viewmodel.admin.OrderVM;
import application.viewmodel.common.ProductVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static application.constant.StatusOrderConstant.delivered;
import static application.constant.StatusOrderConstant.not_deliveried;
import static application.constant.StatusOrderConstant.unpaid;

@Controller
@RequestMapping(path="/")
public class AdminController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;


//    @RequestMapping(path = "admin", method = RequestMethod.GET)
//    public String admin(Model model, @RequestParam(value="pageNumber", required=false) Integer pageNumber) {
//
//        int pageSize = Constant.DEFAULT_PAGE_SIZE;
//
//        AdminVM vm = new AdminVM();
//        long totalProducts = productService.getTotalProducts();
//
//        vm.setMessageTotalProducts("Total existed products: " + totalProducts);
//
//        if(pageNumber == null) {
//            pageNumber = 1;
//        }
//
//        try {
//            PaginableItemList<Product> paginableItemList = productService.getListProducts(Constant.DEFAULT_PAGE_SIZE,
//                    pageNumber - 1);
//
//            List<Product> listProducts = paginableItemList.getListData();
//            ArrayList<ProductVM> listProductVMs = new ArrayList<>();
//            ModelMapper modelMapper = new ModelMapper();
//            for(Product product : listProducts) {
//                ProductVM productVM = modelMapper.map(product, ProductVM.class);
//                listProductVMs.add(productVM);
//            }
//            vm.setListPagingProducts(listProductVMs);
//
//            int totalPages = 0;
//            if(paginableItemList.getTotalProducts() % pageSize == 0) {
//                totalPages = (int)(paginableItemList.getTotalProducts() / pageSize);
//            } else {
//                totalPages = (int)(paginableItemList.getTotalProducts() / pageSize) + 1;
//            }
//
//            vm.setTotalPagingItems(totalPages);
//            vm.setCurrentPage(pageNumber);
//
//            //TODO: get list categories
//            List<Category> listCategories = categoryService.getListAllCategories();
//            ArrayList<CategoryDataModel> dataModelArrayList = new ArrayList<>();
//            for (Category cat :
//                    listCategories) {
//                dataModelArrayList.add(modelMapper.map(cat, CategoryDataModel.class));
//            }
//            vm.setListCategories(dataModelArrayList);
//
//        } catch (Exception e) {
//
//        }
//
//        model.addAttribute("vm", vm);
//
//        return "admin";
//    }

    @RequestMapping(path = "admin/product", method = RequestMethod.GET)
    public String adminProduct(Model model) {
        AdminVM vm = new AdminVM();
        ModelMapper modelMapper = new ModelMapper();
        long totalProducts = productService.getTotalProducts();

        vm.setMessageTotalProducts("Total existed products: " + totalProducts);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<ProductVM> productVMS = new ArrayList<>();
        products = productService.getAllPros();
        for(Product pro : products){
            productVMS.add(modelMapper.map(pro,ProductVM.class));
        }

        vm.setListPagingProducts(productVMS);

        List<Category> listCategories = categoryService.getListAllCategories();
            ArrayList<CategoryDataModel> dataModelArrayList = new ArrayList<>();
            for (Category cat :
                    listCategories) {
                dataModelArrayList.add(modelMapper.map(cat, CategoryDataModel.class));
            }
            vm.setListCategories(dataModelArrayList);

        model.addAttribute("vm", vm);

        return "admin/manage_product";
    }

    @GetMapping("/admin/chat")
    public String adminChat(){
        return "/admin/socket/admin-chat";
    }

    @GetMapping("/admin/chat/user")
    public String userChat(){
        return "/admin/socket/user-chat";
    }

    @GetMapping("/admin/profile")
    public String profile(){
        return "admin/profile";
    }

    @GetMapping("/admin/customer")
    public String customer(){
        return "admin/manage_customer";
    }

    @GetMapping("/admin/category")
    public String category(Model model){
        ModelMapper modelMapper = new ModelMapper();
        List<Category> categories = categoryService.getListAllCategories();
        List<CategoryDataModel> categoryDataModels = new ArrayList<>();
        for(Category c : categories){
            categoryDataModels.add(modelMapper.map(c,CategoryDataModel.class));
        }
        model.addAttribute("vm",categoryDataModels);
        return "/admin/manage_category";
    }

    @GetMapping("/admin/order/deliveried")
    public String delivery(Model model){
        setBill(delivered,model,"Hóa đơn đã được thanh toán");
        return "admin/manage_order";
    }

    @GetMapping("/admin/order/notdeliveried")
    public String notdelivery(Model model){
        setBill(not_deliveried,model,"Hóa đơn đang được giao");
        return "admin/manage_order";
    }

    @GetMapping("/admin/order/unpaid")
    public String unpaid(Model model){
        setBill(unpaid,model,"Giỏ hàng chưa thanh toán");
        return "admin/manage_order";
    }

    public Model setBill(int status, Model model,String info){
        ModelMapper modelMapper = new ModelMapper();
        ArrayList<Order> orders = orderService.getListOrderByStatusId(status);
        ArrayList<OrderDetailModel> orderDetailModels =new ArrayList<>();
        OrderVM orderVM = new OrderVM();
        if(orders != null){
            for(Order o : orders){
                orderDetailModels.add(modelMapper.map(o,OrderDetailModel.class));
            }
            orderVM.setInfo(info);
            orderVM.setObject(orderDetailModels);
            model.addAttribute("order",orderVM);
        }else {
            orderVM.setInfo("Không có hóa đơn nào");
            orderVM.setObject(null);
            model.addAttribute("order",orderVM);
        }
        return model;
    }


}
