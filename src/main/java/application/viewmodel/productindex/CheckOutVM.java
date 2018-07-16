package application.viewmodel.productindex;

import application.data.model.User;
import application.model.OrderProductCheckOutModel;

import java.util.ArrayList;

public class CheckOutVM {
    private ArrayList<OrderProductCheckOutModel> orderProductApiModels;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<OrderProductCheckOutModel> getOrderProductApiModels() {
        return orderProductApiModels;
    }

    public void setOrderProductApiModels(ArrayList<OrderProductCheckOutModel> orderProductApiModels) {
        this.orderProductApiModels = orderProductApiModels;
    }
}
