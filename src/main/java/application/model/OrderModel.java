package application.model;


import java.sql.Date;

public class OrderModel {
    private int id;
    private String userid;
    private String userguild;
    private Date createdDate;
    private Date updatedDate;
    private OrderStatusModel orderStatus;
    private String address;

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public OrderStatusModel getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusModel orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
