package application.viewmodel.homelanding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ManhNguyen on 1/17/18.
 */
public class MenuItemVM {
    private int id;
    private String text;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private List<MenuItemVM> children;

    public MenuItemVM(int id,String text, String link) {
        this.id = id;
        this.text = text;
        this.link = link;
        children = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<MenuItemVM> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItemVM> children) {
        this.children = children;
    }
}
