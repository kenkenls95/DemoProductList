package application.data.service;

import application.data.model.Order;
import application.data.model.OrderProduct;
import application.data.model.OrderStatus;
import application.data.repository.OrderProductRepository;
import application.data.repository.OrderRepository;
import application.data.repository.OrderStatusRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

import static application.constant.StatusOrderConstant.unpaid;

@Service
public class OrderService {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

        public ArrayList<OrderProduct> getAllByOrder(int orderid){
        return orderProductRepository.getAllByOrder(orderid);
    }

    public ArrayList<Object> getOrderByUser(String id){
        return orderRepository.getOrderByUser(id);
    }

    public void addNewOrder(Order order){
             orderRepository.save(order);
    }

    public OrderStatus getOneOrderStatus(int id){
            return orderStatusRepository.getOne(id);
    }

    //login and add userid into tbl_order
    public String setUserGuild(String guild,String userid){
            Order existOrder = orderRepository.findOrderByUserguild(guild);
            if(existOrder == null ){
                return null;
            }else {
                existOrder.setUserid(userid);
                orderRepository.save(existOrder);
                return userid;
            }
    }

    public Order findOrderByUserguild(String guild){
            return orderRepository.findOrderByUserguild(guild);
    }

    public Boolean createNewOrderProduct(int orderid){
        try {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrderid(orderid);
            orderProductRepository.save(orderProduct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Order findOrderByUserIdAndStatusid(String userid, int id){
            return orderRepository.findOrderByUserIdAndStatusId(userid,id);
    }

    public boolean createOrderByUserguild(String guild){
        try {
            Order order = new Order();
            order.setUserguild(guild);
            order.setCreated_date(new Date());
            order.setOrderStatus(orderStatusRepository.getOne(unpaid));
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createOrderByUserId(String id){
        try {
            Order order = new Order();
            order.setUserid(id);
            order.setCreated_date(new Date());
            order.setOrderStatus(orderStatusRepository.getOne(unpaid));
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveOrderProduct(OrderProduct orderProduct){
        try {
            orderProductRepository.save(orderProduct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public OrderProduct findOrderProduct (int productid,int orderid){
            return orderProductRepository.findOrderProductByProductidAndOrderid(productid, orderid);
    }


    public ArrayList<OrderProduct> getListOrderProductByOrderId(int orderid){
            return orderProductRepository.getAllByOrderid(orderid);
    }


    public boolean deleteOrder(int orderid){
        try {
            orderRepository.delete(orderid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean saveListOrderProductByOrderId(ArrayList<OrderProduct> orderProducts){
        try {
            orderProductRepository.save(orderProducts);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
