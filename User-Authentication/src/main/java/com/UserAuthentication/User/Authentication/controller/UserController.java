package com.UserAuthentication.User.Authentication.controller;

import com.UserAuthentication.User.Authentication.DTO.SignUpDTO;
import com.UserAuthentication.User.Authentication.model.User;
import com.UserAuthentication.User.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public User signup(@RequestBody SignUpDTO requestDTO){
    return userService.signup(requestDTO.getEmail(),requestDTO.getPassword(),requestDTO.getUserName());
    }


}
