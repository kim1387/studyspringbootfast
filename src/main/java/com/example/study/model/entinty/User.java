package com.example.study.model.entinty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

// @Table(name = "user") 테이블명과 클래스명이 같다면 선언 안해도 됌
@Data // lombok 자동으로 constructor와 dependable method 선언
@AllArgsConstructor // 모든 매개변수가 들어가는 constructor
@NoArgsConstructor // 디폴트 생성자?
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

}
