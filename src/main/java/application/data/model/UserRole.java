package application.data.model;

import javax.persistence.*;

@Entity(name = "tbl_userrole")
public class UserRole {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private int roleId;

    private int status;

    public UserRole() {
    }

    public UserRole(String userId, int roleId, int status) {
        this.userId = userId;
        this.roleId = roleId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
