package application.model;


import java.util.ArrayList;

public class CategoryProductModel {
    private int id;
    private String name;
    private ArrayList<ProductDetailModel> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ProductDetailModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductDetailModel> products) {
        this.products = products;
    }
}
