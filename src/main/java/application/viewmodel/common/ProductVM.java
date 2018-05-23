package application.viewmodel.common;

import application.model.CategoryDataModel;

/**
 * Created by ManhNguyen on 1/22/18.
 */
public class ProductVM {
    private int id;
    private String name;
    private String image;
    private String shortDesc;
    private int amount;

    private CategoryDataModel category;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public CategoryDataModel getCategory() {
        return category;
    }

    public void setCategory(CategoryDataModel category) {
        this.category = category;
    }
}
