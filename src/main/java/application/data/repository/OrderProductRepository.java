package application.data.repository;

import application.data.model.OrderProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer> {


    @Query("select op from tbl_orderproduct op where op.orderid =:orderid")
    ArrayList<OrderProduct> getAllByOrder(@Param("orderid")int orderid);

    @Query("select op from tbl_orderproduct op where op.productid = :productid and op.orderid = :orderid")
    OrderProduct findOrderProductByProductidAndOrderid(@Param("productid") int productid,
                                             @Param("orderid") int orderid);

    @Query("select op from tbl_orderproduct op where op.orderid = :orderid")
    ArrayList<OrderProduct> getAllByOrderid(@Param("orderid") int orderid);


}
