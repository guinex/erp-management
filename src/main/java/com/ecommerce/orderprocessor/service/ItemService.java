package com.ecommerce.orderprocessor.service;

import com.ecommerce.orderprocessor.entity.Item;
import com.ecommerce.orderprocessor.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ItemService {

    private static final Logger log = LoggerFactory.getLogger(ItemService.class);
    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Optional<Item> getItem(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item createItem(Item item) {
        log.info("Creating item: {}", item);
        try {
            return itemRepository.save(item);
        } catch (Exception ex) {
            log.error("Error creating item: {}", ex.getMessage());
            return null;
        }
    }

    public Item updateItem(Long id, Item item) {
        Optional<Item> existingItem =  itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item updatedItem = existingItem.get();
            updatedItem.setName(item.getName());
            updatedItem.setQuantity(item.getQuantity());
            return itemRepository.save(updatedItem);
        } else {
            return null;
        }
    }
}