package application.data.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ManhNguyen on 10/11/17.
 */
@Entity(name = "tbl_product")
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productid")
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "amount")
    private int amount;

    @Column(name = "shortdesc")
    private String shortDesc;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "price")
    private int price;


    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name="categoryid")
    private Category category;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
