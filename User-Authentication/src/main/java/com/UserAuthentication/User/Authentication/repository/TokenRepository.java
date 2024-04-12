package com.UserAuthentication.User.Authentication.repository;

import com.UserAuthentication.User.Authentication.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepository  extends JpaRepository<Token,Long> {
    Optional<Token> findByValue(String value);

    Optional<Token> findByValueAndExpiredAtGreaterThanAndDeletedEquals(String value, Date date, boolean b);
}
