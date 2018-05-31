package application.data.repository;

import application.data.model.OrderProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer> {


    @Query("select op from tbl_orderproduct op " +
            "where op.orderid =:orderid")
    ArrayList<OrderProduct> getAllByOrder(@Param("orderid")int orderid);

//    @Query("select op.productid, SUM(op.orderquantity) as total " +
//            "from orderproduct op " +
//            "group by op.productid " +
//            " ORDER BY total")
//    ArrayList<Object> getOrderProductByTop();
}
