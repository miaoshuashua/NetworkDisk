package com.chuankeji.bean;

import java.util.List;

public class Role {
    private int id;
    private String roleName2;
    private List<User> userList;

    public Role(int id, String roleName2, List<User> userList) {
        this.id = id;
        this.roleName2 = roleName2;
        this.userList = userList;
    }

    public Role() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName2() {
        return roleName2;
    }

    public void setRoleName2(String roleName2) {
        this.roleName2 = roleName2;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
