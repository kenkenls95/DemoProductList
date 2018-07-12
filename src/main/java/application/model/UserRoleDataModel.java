package application.model;

import application.data.model.Role;
import application.data.model.User;

public class UserRoleDataModel {
    private int id;
    private User user;
    private Role role;
    private String status;


    public UserRoleDataModel(int id, User user, Role role, String status) {
        this.id = id;
        this.user = user;
        this.role = role;
        this.status = status;
    }

    public UserRoleDataModel() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
