package com.chuankeji.bean;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String sex;
    private String eduction2;
    private String truename;
    private Date registrationTime;
    private String registrationTimeStr;
    private int integral;
    private int upload;
    private String userStatus;
    private int downloadNumer;
    private String roleName2;
    private Role role;

    public User(int id, String username, String password, String email, String phone, String sex, String eduction2, String truename, Date registrationTime, String registrationTimeStr, int integral, int upload, String userStatus, int downloadNumer, String roleName2, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.eduction2 = eduction2;
        this.truename = truename;
        this.registrationTime = registrationTime;
        this.registrationTimeStr = registrationTimeStr;
        this.integral = integral;
        this.upload = upload;
        this.userStatus = userStatus;
        this.downloadNumer = downloadNumer;
        this.roleName2 = roleName2;
        this.role = role;
    }

    public User() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return eduction2;
    }

    public void setEducation(String eduction2) {
        this.eduction2 = eduction2;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getUpload() {
        return upload;
    }

    public void setUpload(int upload) {
        this.upload = upload;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public int getDownloadNumer() {
        return downloadNumer;
    }

    public void setDownloadNumer(int downloadNumer) {
        this.downloadNumer = downloadNumer;
    }

    public String getRegistrationTimeStr() {
        return registrationTimeStr;
    }

    public void setRegistrationTimeStr(String registrationTimeStr) {
        this.registrationTimeStr = registrationTimeStr;
    }

    public String getRoleName2() {
        return roleName2;
    }

    public void setRoleName2(String roleName2) {
        this.roleName2 = roleName2;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
