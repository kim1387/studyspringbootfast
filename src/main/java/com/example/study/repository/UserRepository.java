package com.example.study.repository;

import com.example.study.model.entinty.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {//어떤 타입의 object인지 USER(클래스명) 기본키의 타입은? Long

    // select * from user WHERE account = ? << test3
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);
}
