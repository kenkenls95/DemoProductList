package application.model;

import java.util.Date;

public class OrderProductDataModel {
    private Object product;
    private long orderprice;
    private int orderquantity;
    private Date created_date;

    public OrderProductDataModel(Object product, long orderprice, int orderquantity, Date created_date) {
        this.product = product;
        this.orderprice = orderprice;
        this.orderquantity = orderquantity;
        this.created_date = created_date;
    }

    public Object getProduct() {
        return product;
    }

    public void setProduct(Object product) {
        this.product = product;
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

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
