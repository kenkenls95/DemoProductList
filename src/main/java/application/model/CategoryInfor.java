package application.model;


import java.util.ArrayList;

public class CategoryInfor {
    private int parentid;
    private String parentname;
    private ArrayList<CategoryDetailModel> categories;

    public ArrayList<CategoryDetailModel> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryDetailModel> categories) {
        this.categories = categories;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }
}
