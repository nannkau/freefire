package com.example.freefire.repository;

import com.example.freefire.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findByEnabled(String enable);
}
