package application.data.model;

import javax.persistence.*;
import java.util.*;

@Entity(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userid;
    private String userguild;
    private Date created_date;
    private Date updated_date;

//    private int statusid;
    private String address;
//
//    @OneToMany(mappedBy = "order")
//    private List<OrderProduct> orderProducts= new ArrayList<OrderProduct>();

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name="statusid")
    private OrderStatus orderStatus;

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserguild() {
        return userguild;
    }

    public void setUserguild(String userguild) {
        this.userguild = userguild;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
