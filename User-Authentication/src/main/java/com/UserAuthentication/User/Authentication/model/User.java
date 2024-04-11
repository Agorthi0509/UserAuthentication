package com.UserAuthentication.User.Authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel {
    private String username;
    private String email;
    private String password;
    @ManyToMany
    private List<Role> roles;

    private boolean isVerified;
    public User(){

    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles= new ArrayList<>();
        this.isVerified=false;
    }
}
