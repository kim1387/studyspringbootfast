package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entinty.Item;
import com.example.study.model.entinty.User;
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
    @Transactional
    public void read(){

    }

}