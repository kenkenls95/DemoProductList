package application.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tbl_orderproduct")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int productid;
    private int orderid;
    private int orderprice;
    private int orderquantity;
    private Date created_date;
    private Date updated_date;

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    //    @ManyToOne(optional = true, fetch = FetchType.LAZY)
//    @JoinColumn(name="orderid")
//    private Order order;
//
//    @ManyToOne(optional = true, fetch = FetchType.LAZY)
//    @JoinColumn(name="productid")
//    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(int orderprice) {
        this.orderprice = orderprice;
    }

    public int getOrderquantity() {
        return orderquantity;
    }

    public void setOrderquantity(int orderquantity) {
        this.orderquantity = orderquantity;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
}
