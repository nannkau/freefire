package com.example.freefire.service;

import com.example.freefire.dto.ItemDTO;
import com.example.freefire.entity.Item;

import java.util.List;

public interface IItemService {
    List<Item> findAll();
    Item save(ItemDTO itemDTO);
    Item getById(Integer id);
    ItemDTO getItemDTOById(Integer id);
    void deleteById(Integer id);
    List<Item> findEnable();
}
