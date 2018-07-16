package application.model;

import java.util.Date;

public class OrderProductApiModel {
    private int productId;
    private ProductDetailModel productDetailModel;
    private int orderQuantity;
    private int orderPrice;
    private Date createdDate;
    private int orderId;

    public OrderProductApiModel(int productId, ProductDetailModel productDetailModel, int orderQuantity, int orderPrice, Date createdDate, int orderId) {
        this.productId = productId;
        this.productDetailModel = productDetailModel;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.createdDate = createdDate;
        this.orderId = orderId;
    }

    public OrderProductApiModel() {
    }

    public ProductDetailModel getProductDetailModel() {
        return productDetailModel;
    }

    public void setProductDetailModel(ProductDetailModel productDetailModel) {
        this.productDetailModel = productDetailModel;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
