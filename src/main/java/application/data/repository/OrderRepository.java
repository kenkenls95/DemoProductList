package application.data.repository;

import application.data.model.Order;
import application.data.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("select o from tbl_order o where o.userid =:id")
    ArrayList<Object> getOrderByUser(@Param("id")String id);

    @Query("select o from tbl_order o where o.userguild = :userguild")
    Order findOrderByUserguild(@Param("userguild") String userguild);

    @Query("select o from tbl_order o where o.userid = :userid and o.orderStatus.id = :id")
    Order findOrderByUserIdAndStatusId(@Param("userid")String userid,
                        @Param("id") int id);

    @Query("select o from tbl_order o where o.userguild = :userguild and o.orderStatus.id = :id")
    Order findOrderByUserGuildAndStatusId(@Param("userguild")String userguild,
                                       @Param("id") int id);

    @Query("select o from tbl_order o where o.orderStatus.id = :statusId")
    ArrayList<Order> getListOrderByStatusId(@Param("statusId") int statusId);

    @Query("select o from tbl_order o")
    ArrayList<Order> getListOrder();
}
