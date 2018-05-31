package application.model;

import java.util.Date;

public class OrderProductDetailModel {
    private int id;
    private int productid;
    private long orderprice;
    private int orderquantity;
    private Date created_date;

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public OrderProductDetailModel(int id, int productid, long orderprice, int orderquantity, Date created_date) {
        this.id = id;
        this.productid = productid;
        this.orderprice = orderprice;
        this.orderquantity = orderquantity;
        this.created_date = created_date;
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

    public long getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(long orderprice) {
        this.orderprice = orderprice;
    }

    public int getOrderquantity() {
        return orderquantity;
    }

    public void setOrderquantity(int orderquantity) {
        this.orderquantity = orderquantity;
    }
}
