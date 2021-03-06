package application.controller.api;

import application.data.model.*;
import application.data.service.CategoryService;
import application.data.service.OrderService;
import application.data.service.ProductService;
import application.model.*;
import application.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static application.constant.StatusOrderConstant.not_deliveried;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    private String[] images = {
            "https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg"
    };

    @GetMapping("/detail/{productId}")
    public BaseApiResult detailProduct(@PathVariable int productId) {
        DataApiResult result = new DataApiResult();
        try{
            Product existProduct = productService.findOne(productId);
            if(existProduct == null) {
                result.setSuccess(false);
                result.setMessage("Can't find this product");
            } else {
                result.setSuccess(true);
                ModelMapper modelMapper = new ModelMapper();
                ProductDetailModel productDetailModel =
                        modelMapper.map(existProduct, ProductDetailModel.class);
                result.setData(productDetailModel);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping("/list-products/{categoryId}")
    public BaseApiResult listProductByCat(@PathVariable int categoryId) {
        DataApiResult result = new DataApiResult();
        try{
            Category existCategory = categoryService.findOne(categoryId);
            if(existCategory == null) {
                result.setSuccess(false);
                result.setMessage("Can't find this product");
            } else {
                result.setSuccess(true);
                ModelMapper modelMapper = new ModelMapper();
                ArrayList<ProductDetailModel> listProducts = new ArrayList<>();
                if(existCategory.getProducts() != null) {
                    for (Product p : existCategory.getProducts()) {
                        ProductDetailModel productDetailModel =
                                modelMapper.map(p, ProductDetailModel.class);
                        listProducts.add(productDetailModel);
                    }
                }
                result.setData(listProducts);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping("/findbyname/{productName}")
    public BaseApiResult listProductByName(@PathVariable String productName) {
        DataApiResult result = new DataApiResult();
        try{
            Object existProduct = productService.findByName(productName);
            ModelMapper modelMapper = new ModelMapper();
            ProductDetailModel productDetailModel = modelMapper.map(existProduct,ProductDetailModel.class);
            if(productDetailModel == null) {
                result.setSuccess(false);
                result.setMessage("Can't find this product");
            } else {
                result.setSuccess(true);
                }
                result.setData(productDetailModel);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping("/getallproduct")
    public BaseApiResult getAllName() {
        DataApiResult result = new DataApiResult();
        ModelMapper modelMapper = new ModelMapper();
        try{
            ArrayList<Product> products  = productService.getAllPros();
            ArrayList<ProductSearchModel> productSearchModels = new ArrayList<>();
            for (Product p : products){
                productSearchModels.add(modelMapper.map(p,ProductSearchModel.class));
            }
            result.setSuccess(true);
            result.setData(productSearchModels);
            result.setMessage("'success");
        } catch (Exception e) {
            result.setData(null);
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/fake-products")
    public BaseApiResult fakeProducts() {
        ArrayList<Product> listProducts= new ArrayList<>();
        Random random = new Random();
        BaseApiResult result = new BaseApiResult();
        int list[] = {1,2,3,4,5,6,7};

        for(int i = 1; i <= 100; ++i) {
            Product p = new Product();
            p.setCreatedDate(new Date());
            p.setName("Product " + i);
            p.setShortDesc("Description for product " + i);
            p.setImage(images[random.nextInt(images.length)]);
            p.setCategory(categoryService.getOne(list[random.nextInt(list.length)]));
            p.setPrice(random.nextInt(100));
            p.setAmount(random.nextInt(100));
            listProducts.add(p);
        }

        productService.addNewListProducts(listProducts);
        result.setSuccess(true);
        result.setMessage("Done");
        return result;
    }

    @PostMapping("/create-product")
    public BaseApiResult createProduct(@RequestBody ProductDataModel product) {
        DataApiResult result = new DataApiResult();

        try {
            if(!"".equals(product.getName()) && !"".equals(product.getShortDesc()) && !"".equals(product.getImage()) && !"".equals(product.getPrice())) {
                ModelMapper modelMapper = new ModelMapper();
                Product productEntity = modelMapper.map(product, Product.class);
                productEntity.setCategory(categoryService.getOne(product.getCategoryId()));
                productService.addNewProduct(productEntity);
                result.setSuccess(true);
                result.setMessage("Save product successfully: " + productEntity.getId());
                result.setData(productEntity.getId());
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

    @PostMapping("/update-product/{productId}")
    public BaseApiResult updateProduct(@PathVariable int productId,
                                       @RequestBody ProductDataModel product) {
        BaseApiResult result = new BaseApiResult();

        try {
            if(!"".equals(product.getName()) && !"".equals(product.getShortDesc())
                        && !"".equals(product.getImage())) {
                // check existed product
                Product existProduct = productService.findOne(productId);
                if(existProduct == null) {
                    result.setSuccess(false);
                    result.setMessage("Invalid model");
                } else {
                    existProduct.setImage(product.getImage());
                    existProduct.setName(product.getName());
                    existProduct.setCreatedDate(product.getCreatedDate());
                    existProduct.setShortDesc(product.getShortDesc());
                    existProduct.setAmount(product.getAmount());
                    existProduct.setPrice(product.getPrice());
                    existProduct.setCategory(categoryService.getOne(product.getCategoryId()));
                    productService.updateProduct(existProduct);
                    result.setSuccess(true);
                    result.setMessage("Update product successfully");
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

    @PostMapping("/delete-product")
    public BaseApiResult deleteProduct(@RequestBody ProductDeleteDataModel product) {
        BaseApiResult result = new BaseApiResult();

        try {
            if(productService.deleteProduct(product.getProductId())) {
                result.setSuccess(true);
                result.setMessage("Delete product successfully");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }

    @PostMapping("/update-orderproduct")
    public BaseApiResult updateOrderProduct(@RequestBody OrderProductApiModel orderProductApiModel){
        DataApiResult result = new DataApiResult();
        try {
            OrderProduct existOrderProduct = orderService.findOrderProduct(orderProductApiModel.getProductId(), orderProductApiModel.getOrderId());
            if(existOrderProduct != null){
                existOrderProduct.setOrderquantity(existOrderProduct.getOrderquantity() + orderProductApiModel.getOrderQuantity());
                orderService.saveOrderProduct(existOrderProduct);
                result.setSuccess(true);
                result.setMessage("update success");
                result.setData(existOrderProduct);
            }else {
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setProductid(orderProductApiModel.getProductId());
                orderProduct.setOrderquantity(orderProductApiModel.getOrderQuantity());
                orderProduct.setOrderprice(orderProductApiModel.getOrderPrice());
                orderProduct.setOrderid(orderProductApiModel.getOrderId());
                orderProduct.setCreated_date(new Date());
                orderService.saveOrderProduct(orderProduct);
                result.setSuccess(true);
                result.setMessage("success");
                result.setData(orderProduct);
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setData(null);
            result.setSuccess(false);
        }
        return result;
    }

    @PostMapping("/save")
    public BaseApiResult saveOrder(@RequestBody UserOrderModel userOrderModel){
        DataApiResult result = new DataApiResult();
        ModelMapper modelMapper = new ModelMapper();
        User user = userService.findUserById(userOrderModel.getId());
        if(user != null){
            user.setPhone(userOrderModel.getPhone());
            user.setAddress(userOrderModel.getAddress());
            user.setEmail(userOrderModel.getEmail());
            user.setFullname(userOrderModel.getFullname());
            userService.updateUser(user);
            Order order = orderService.findOrder(userOrderModel.getOrderId());
            order.setOrderStatus(orderService.getOneOrderStatus(not_deliveried));
            order.setUserid(user.getId());
            order.setAddress(user.getAddress());
            orderService.saveOrder(order);
            result.setData(user);
            result.setMessage("Đã lưu thành công");
            result.setSuccess(true);
        }else {
            if(userService.findUserByEmail(userOrderModel.getEmail()) != null){
                result.setSuccess(false);
                result.setData(null);
                result.setMessage("Tồn tại email");
            }else {
                User user1 = modelMapper.map(userOrderModel,User.class);
                userService.saveUser(user1);
                result.setData(user1);
                result.setMessage("Đã lưu thành công");
                result.setSuccess(true);
                result.setData(user1);
                User user2 = userService.findUserByEmail(user1.getEmail());
                Order order = orderService.findOrder(userOrderModel.getOrderId());
                order.setOrderStatus(orderService.getOneOrderStatus(not_deliveried));
                order.setUserid(user2.getId());
                order.setAddress(user2.getAddress());
                orderService.saveOrder(order);
            }
        }

        return result;
    }
}
