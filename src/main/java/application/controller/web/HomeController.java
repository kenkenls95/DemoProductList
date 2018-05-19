package application.controller.web;



import application.data.model.Category;
import application.data.model.PaginableItemList;
import application.data.model.Product;
import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.model.CategoryDataModel;
import application.model.CategoryDetailModel;
import application.model.CategoryInfor;
import application.viewmodel.admin.AdminVM;
import application.viewmodel.common.ProductVM;
import application.viewmodel.homelanding.BannerVM;
import application.viewmodel.homelanding.HomeLandingVM;
import application.viewmodel.homelanding.MenuItemVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

import static application.constant.Constant.DEFAULT_PARENT_ID;

/**
 * Created by ManhNguyen on 10/11/17.
 */

@Controller
@RequestMapping(path="/")
public class HomeController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path="/list-products")
    public String index(Model model,
                        @RequestParam(value="pageSize", required=false) 
                        String ps,
                        @RequestParam(value="pageNumber", required=false) 
                        String pn){

        try {
            int pageSize = Integer.parseInt(ps);
            int pageNumber = Integer.parseInt(pn);
            if(pageSize > 0 && pageNumber >= 0) {
                model.addAttribute("paginableItem", 
                    productService.getListProducts(pageSize, pageNumber));
            } else {
                model.addAttribute("paginableItem", 
                    productService.getListProducts(10, 0));
            }
        } catch (Exception ex) {
            model.addAttribute("paginableItem", 
                productService.getListProducts(10, 0));
        }

        return "list_product";
    }

    @GetMapping(path="/")
    public String landing(Model model, HttpServletResponse response,
                          @RequestHeader("User-Agent") String userAgent,
                          HttpServletRequest request) {

        response.addCookie(new Cookie("current-page",
                "Cookie From Java code - Home landing"));
        System.out.println("====================");
        System.out.println(userAgent);
        System.out.println("IP: " + request.getRemoteAddr());

        HomeLandingVM vm = new HomeLandingVM();

        this.setLayoutHeaderVM(vm);

        ModelMapper modelMapper = new ModelMapper();


        ArrayList<BannerVM> listBanners = new ArrayList<>();
        listBanners.add(new BannerVM("https://media.static-adayroi.com/sys_master/h75/hac/15516679143454.jpg", "Tươi"));
        listBanners.add(new BannerVM("http://www.creavini.it/wp-content/uploads/2017/05/uva.png", "Nho Mỹ"));
        listBanners.add(new BannerVM("https://edeka-tank.de/wp-content/uploads/2017/01/Fotolia_43618946_Tomaten_mood.jpg", "Cà Chua"));
        listBanners.add(new BannerVM("https://dalat.net.vn/images/uploads/gia-dau-tay-da-lat-2.jpg", "Dâu Tây"));

        ArrayList<MenuItemVM> listVtMenuItems = new ArrayList<>();
        for(CategoryInfor cat : getCategories()){
            listVtMenuItems.add(new MenuItemVM(cat.getParentname(),"/"));
            ArrayList<CategoryDetailModel> categoryDetailModels = new ArrayList<>();
            if(cat.getCategories() != null){
                for(CategoryDetailModel categoryDetailModel : cat.getCategories()){
                    categoryDetailModels.add(modelMapper.map(categoryDetailModel,CategoryDetailModel.class));
                }
                for(CategoryDetailModel categoryDetailModel : categoryDetailModels){
                    listVtMenuItems.get(cat.getParentid() - DEFAULT_PARENT_ID).getChildren().add(new MenuItemVM(categoryDetailModel.getName(),"/"));
                }
            }
        }


        PaginableItemList<Product> paginableItemListHot = productService.getListProducts(8, 0);
        ArrayList<ProductVM> listHotProductVMs = new ArrayList<>();
        for(Product product : paginableItemListHot.getListData()) {
            ProductVM productVM = modelMapper.map(product, ProductVM.class);
            listHotProductVMs.add(productVM);
        }

        PaginableItemList<Product> paginableItemListTrend = productService.getListProducts(8, 1);
        ArrayList<ProductVM> listTrendProductVMs = new ArrayList<>();
        for(Product product : paginableItemListTrend.getListData()) {
            ProductVM productVM = modelMapper.map(product, ProductVM.class);
            listTrendProductVMs.add(productVM);
        }

        vm.setListBanners(listBanners);
        vm.setListVtMenuItemsAside(listVtMenuItems);
        vm.setListHotProducts(listHotProductVMs);
        vm.setListTrendProducts(listTrendProductVMs);

        model.addAttribute("vm", vm);
        return "index";
    }


    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/user")
    public String user(){
        return "/user";
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
                if(getChil(cat.getId()).size() > 0){
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
        ArrayList<CategoryDetailModel> categoryDetailModels = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(Object cat : list){
            categoryDetailModels.add(modelMapper.map(cat,CategoryDetailModel.class));
        }
        return categoryDetailModels;
    }


}
