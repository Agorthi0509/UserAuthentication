package com.UserAuthentication.User.Authentication.repository;

import com.UserAuthentication.User.Authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
