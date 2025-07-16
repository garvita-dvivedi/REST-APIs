package com.studentManagementSystem.studentSystem.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// this the actual table present in the database and is used for performing sql queries
@Entity
@Table (name = "Users")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId ;
    private  String name;
    private String password;
    private String email;

    //getter and setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
