package application.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ManhNguyen on 3/30/18.
 */
@Entity(name = "tbl_category")
public class Category {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid")
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    private String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
