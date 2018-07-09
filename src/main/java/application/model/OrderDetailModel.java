package application.model;

import application.extension.CustomDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class OrderDetailModel {
    private int id;
    private String userid;
    private String userguild;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date created_date;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date updated_date;
    private String address;
    private OrderStatusModel orderStatusModel;

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

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderStatusModel getOrderStatusModel() {
        return orderStatusModel;
    }

    public void setOrderStatusModel(OrderStatusModel orderStatusModel) {
        this.orderStatusModel = orderStatusModel;
    }
}
