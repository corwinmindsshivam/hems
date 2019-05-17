package com.corwinminds.hesmb.Model;

public class User {
    public User(int userId, String userEmail, String userPhone, String verified) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.verified = verified;
    }

    private int userId;
    public String userEmail;

    private String userPhone;
    private String verified;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }




}