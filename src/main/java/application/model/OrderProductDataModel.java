package application.model;

import application.extension.CustomDateDeserializer;
import application.extension.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class OrderProductDataModel {
    private Object product;
    private long orderprice;
    private int orderquantity;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date created_date;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date updated_date;

    public OrderProductDataModel(Object product, long orderprice, int orderquantity, Date created_date, Date updated_date) {
        this.product = product;
        this.orderprice = orderprice;
        this.orderquantity = orderquantity;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
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
