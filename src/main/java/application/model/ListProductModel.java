package application.model;

import java.util.Date;

public class ListProductModel {
    private int orderId;
    private Object Products;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Object getProducts() {
        return Products;
    }

    public void setProducts(Object products) {
        Products = products;
    }
}
