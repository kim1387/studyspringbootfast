package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entinty.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OrderDetailRepositoryTest extends StudyApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    @Transactional
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());

        //orderDetail.setUserId(7L); user를 타입을 User로 바꿨음

        //orderDetail.setItemId(4L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        Assertions.assertNotNull(newOrderDetail);
    }
}