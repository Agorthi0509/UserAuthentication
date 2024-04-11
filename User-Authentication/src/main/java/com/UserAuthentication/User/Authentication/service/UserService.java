package com.UserAuthentication.User.Authentication.service;

import com.UserAuthentication.User.Authentication.model.User;
import com.UserAuthentication.User.Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
   private UserRepository userRepository;
    @Autowired
   private  BCryptPasswordEncoder bCryptPasswordEncoder; //We dont have a class to autowire so creating in config

    public User signup(String email, String password, String name){
        User user = new User(); //we are saving  so we need to create an object
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setUsername(name);



      return userRepository.save(user);






    }


}
