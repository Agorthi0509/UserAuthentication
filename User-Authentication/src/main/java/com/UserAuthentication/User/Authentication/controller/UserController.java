package com.UserAuthentication.User.Authentication.controller;

import com.UserAuthentication.User.Authentication.DTO.LoginDTO;
import com.UserAuthentication.User.Authentication.DTO.SignUpDTO;
import com.UserAuthentication.User.Authentication.model.Token;
import com.UserAuthentication.User.Authentication.model.User;
import com.UserAuthentication.User.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/login")
    public Token login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO.getEmail(),loginDTO.getPassword());

    }
    @PostMapping("/logout/{token}")
    public ResponseEntity<Void> logout(@PathVariable("token") String token){
        userService.logout(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/validate/{token}")
    public boolean validate(@PathVariable("token") String token){
        return userService.validate(token);
    }


}
