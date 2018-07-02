package application.controller.api;

import application.data.model.OrderProduct;
import application.data.service.OrderService;
import application.data.service.ProductService;
import application.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/order")
public class OrderApiController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;


    @GetMapping("/user/{id}")
    public BaseApiResult getOrderByUser(@PathVariable String id){
        DataApiResult result = new DataApiResult();
        ModelMapper modelMapper = new ModelMapper();

        try {
            ArrayList<Object> objects = new ArrayList<>();
            ArrayList<OrderModel> orderModels = new ArrayList<>();
            objects = orderService.getOrderByUser(id);
            for(Object o : objects){
                orderModels.add(modelMapper.map(o,OrderModel.class));
            }
            result.setMessage("success");
            result.setData(orderModels);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setData(null);
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping("/detail/{id}")
    public BaseApiResult getAllByOrder(@PathVariable int id){
        DataApiResult result = new DataApiResult();
        ModelMapper modelMapper = new ModelMapper();

        try {
            ArrayList<OrderProduct> orderProducts= orderService.getAllByOrder(id);
            ArrayList<OrderProductDetailModel> orderProductDetailModels = new ArrayList<>();
            ArrayList<OrderProductDataModel> orderProductDataModels = new ArrayList<>();
            for(OrderProduct orderProduct : orderProducts){
                orderProductDetailModels.add(new OrderProductDetailModel(orderProduct.getId(),orderProduct.getProductid(),orderProduct.getOrderprice(),orderProduct.getOrderquantity(),orderProduct.getCreated_date(),orderProduct.getUpdated_date()));
            }
            for(OrderProductDetailModel o : orderProductDetailModels){
                orderProductDataModels.add(new OrderProductDataModel(modelMapper.map(productService.findById(o.getProductid()),ProductDetailModel.class),o.getOrderprice(),o.getOrderquantity(),o.getCreated_date(),o.getUpdated_date()));
            }

            ListProductModel listProductModel = new ListProductModel();
            listProductModel.setOrderId(id);
            listProductModel.setProducts(orderProductDataModels);
            result.setMessage("success");
            result.setData(listProductModel);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setData(null);
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

//    @GetMapping("/top")
//    public BaseApiResult getTopProduct(){
//        DataApiResult result = new DataApiResult();
//
//        try {
//            ArrayList<Object> objects = orderService.getProductTop();
//
//
//            result.setMessage("success");
//            result.setData(objects);
//            result.setSuccess(true);
//        } catch (Exception e) {
//            result.setData(null);
//            result.setSuccess(false);
//            result.setMessage(e.getMessage());
//        }
//        return result;
//    }

}
