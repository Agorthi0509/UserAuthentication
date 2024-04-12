package com.UserAuthentication.User.Authentication.service;

import com.UserAuthentication.User.Authentication.model.Token;
import com.UserAuthentication.User.Authentication.model.User;
import com.UserAuthentication.User.Authentication.repository.TokenRepository;
import com.UserAuthentication.User.Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
   private UserRepository userRepository;
    @Autowired
   private  BCryptPasswordEncoder bCryptPasswordEncoder; //We dont have a class to autowire so creating in config
    @Autowired
    private TokenRepository tokenRepository;

    public User signup(String email, String password, String name){
        User user = new User(); //we are saving  so we need to create an object
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setUsername(name);



      return userRepository.save(user);






    }


    public Token login(String email, String password) {
        Optional<User> userOptional= userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            throw new RuntimeException("Invalid email and password");
        }
        User user = userOptional.get();
        if(!bCryptPasswordEncoder.matches(password,user.getPassword())){
            throw new RuntimeException("Invalid email and password");
        }
        Token token = new Token();
        token.setUser(user);
        token.setValue(UUID.randomUUID().toString());
        token.setExpiredAt(getExpiryDate());
        return tokenRepository.save(token);
    }

    private Date getExpiryDate() {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.add(Calendar.DAY_OF_MONTH,30);
        Date expiryDate= calendarDate.getTime();
        return expiryDate;
    }

    public void logout(String value) {
        Optional<Token> tokenOptional= tokenRepository.findByValue(value);
        if(tokenOptional.isEmpty()){
            throw new RuntimeException("Invalid Token");
        }
        Token tokenObject = tokenOptional.get();
        tokenObject.setDeleted(true);

        tokenRepository.save(tokenObject);
    }

    public boolean validate(String value) {
        //value shld be valid,expirydate should be greater and deleate is false

        Optional<Token> tokenOptional = tokenRepository.findByValueAndExpiredAtGreaterThanAndDeletedEquals(value,new Date(),false);
        if(tokenOptional.isEmpty()){
            return false;
        }

        return true;
    }
}
