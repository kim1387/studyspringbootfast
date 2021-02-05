package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entinty.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Transactional
    public void create(){

        Item item = new Item();
        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성 노트북");

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }
    @Test
    @Transactional
    public void delete(){

        Optional<Item> item = itemRepository.findById(4L);
        Assertions.assertTrue(item.isPresent());
        item.ifPresent(selectedItem->{
            itemRepository.delete(selectedItem);
        });
        Optional<Item> deletedItem = itemRepository.findById(4L);
        Assertions.assertFalse(deletedItem.isPresent());
    }

    @Test
    public void read(){
        Long id = 4L;
        Optional<Item> item = itemRepository.findById(4L);
        Assertions.assertTrue(item.isPresent());
//        item .ifPresent(item1 ->{
//            System.out.println(item1);
//        });
    }

}