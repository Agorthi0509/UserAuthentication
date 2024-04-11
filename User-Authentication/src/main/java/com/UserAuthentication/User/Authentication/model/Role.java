package com.UserAuthentication.User.Authentication.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role  extends  BaseModel{
    private String name;
}
