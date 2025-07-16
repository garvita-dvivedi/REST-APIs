package com.studentManagementSystem.studentSystem.dto;
// it is the credentials shared by the user and we need to verify using sql query in db
public class LoginRequest {
    private String userId;
    private String password;

    // getter and setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
