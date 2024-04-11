package com.UserAuthentication.User.Authentication.DTO;

import com.UserAuthentication.User.Authentication.model.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SignUpDTO extends BaseModel {
    private String userName;
    private String email;
    private String password;
}
