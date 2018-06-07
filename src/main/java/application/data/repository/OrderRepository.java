package application.data.repository;

import application.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("select o from tbl_order o where o.userid =:id")
    ArrayList<Object> getOrderByUser(@Param("id")int id);

}
