package application.model;

import application.extension.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class OrderProductDetailModel {
    private int id;
    private int orderid;
    private int productid;
    private int orderprice;
    private int orderquantity;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date created_date;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date updated_date;

    public OrderProductDetailModel(int id, int productid, int orderprice, int orderquantity, Date created_date, Date updated_date) {
        this.id = id;
        this.productid = productid;
        this.orderprice = orderprice;
        this.orderquantity = orderquantity;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public OrderProductDetailModel() {
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
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
}
