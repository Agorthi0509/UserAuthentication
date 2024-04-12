package com.UserAuthentication.User.Authentication.repository;

import com.UserAuthentication.User.Authentication.model.Token;
import com.UserAuthentication.User.Authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);


}
