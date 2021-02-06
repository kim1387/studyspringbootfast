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

    @Id//식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY)//관리 전략 옵션
    private Long id;

    //@Column(name = "account") java 컬럼의 변수 이름과 db 컬럼 변수의 이름이 다르다면 써준다.
    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
    //1:N
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<OrderDetail> orderDetailList;
}
