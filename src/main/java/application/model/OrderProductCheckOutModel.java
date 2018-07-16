package application.model;


public class OrderProductCheckOutModel {
    private int id;
    private String imageurl;
    private String name;
    private int orderQuantity;
    private int orderPrice;

    public OrderProductCheckOutModel() {
    }

    public OrderProductCheckOutModel(int id, String imageurl, String name, int orderQuantity, int orderPrice) {

        this.id = id;
        this.imageurl = imageurl;
        this.name = name;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
