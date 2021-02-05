package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entinty.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

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
        // String sql insert into user (%s %s, %d) value (account, email, age);
        User user = new User();
        //user.setId(); AI이므로 자동으로 값이 들어감
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser1");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);// lombok에서 toString을 자동으로 생성
    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);// 2L인 이유는 LONG Type이기 때문


        user.ifPresent(selectedUser ->{
            System.out.println("user : "+selectedUser);
            System.out.println("email : "+selectedUser.getEmail());
        } );

    }
    @Test
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
    public void delete(){
        Optional<User> user = userRepository.findById(2L);// 2L인 이유는 LONG Type이기 때문 2번 선택

        user.ifPresent(selectedUser ->{
            userRepository.delete(selectedUser); // delete이기 때문에 반환값이 없음

        } );
        Optional<User> deleteUser = userRepository.findById(2L);

        if (deleteUser.isPresent()){
            System.out.println("데이터 존재 : "+deleteUser.get());
        }else{
            System.out.println("데이터 삭제 데이터 없음");
        }
    }

}