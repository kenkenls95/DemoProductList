package application.data.model;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String username;
    private String fullname;
    private String email;

    @Column(name = "passwordhashed")
    private String passwordHashed;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Transient
    private String password;

    public User() {
    }

    public User(String username, String fullname, String email, String passwordHashed, Date createdDate, Date updatedDate, String password) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.passwordHashed = passwordHashed;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHashed() {
        return passwordHashed;
    }

    public void setPasswordHashed(String passwordHashed) {
        this.passwordHashed = passwordHashed;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
