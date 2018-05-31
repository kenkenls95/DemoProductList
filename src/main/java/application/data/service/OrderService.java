package application.data.service;

import application.data.model.OrderProduct;
import application.data.repository.OrderProductRepository;
import application.data.repository.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

        public ArrayList<OrderProduct> getAllByOrder(int orderid){
        return orderProductRepository.getAllByOrder(orderid);
    }

    public ArrayList<Object> getOrderByUser(int id){
        return orderRepository.getOrderByUser(id);
    }

//    public ArrayList<Object> getProductTop(){
//            return orderProductRepository.getOrderProductByTop();
//    }
}
