package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entinty.Item;
import com.example.study.model.entinty.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest extends StudyApplicationTests {
    //Dependency Injection
    @Autowired // DI 객체를 관리 자동으로 객체를 찾아서 주입
    //private UserRepository userRepository = new UserRepository(); 이렇게 쓰는 것이 아니라
    private UserRepository userRepository;

    @Test
    public void create(){

    }

    @Test
    @Transactional
    public void read(){

    }
    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(2L);// 2L인 이유는 LONG Type이기 때문

        user.ifPresent(selectedUser ->{
            selectedUser.setAccount("PPPP");
            selectedUser.setUpdatedAt(LocalDateTime.now());
            selectedUser.setUpdatedBy("Update method");

            userRepository.save(selectedUser);
        } );
    }
    //@DeleteMapping("/api/user")
    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(7L);// 2L인 이유는 LONG Type이기 때문 2번 선택
        Assertions.assertTrue(user.isPresent()); // real test code 값을 찾아 왔을 때 값이 있어야하고

        user.ifPresent(selectedUser ->{
            userRepository.delete(selectedUser); // delete이기 때문에 반환값이 없음

        } );
        Optional<User> deleteUser = userRepository.findById(7L);
//
//        if (deleteUser.isPresent()){
//            System.out.println("데이터 존재 : "+deleteUser.get());
//        }else{
//            System.out.println("데이터 삭제 데이터 없음");
//        }
        Assertions.assertFalse(deleteUser.isPresent()); // false여야 한다 지워졌으므로
    }

}