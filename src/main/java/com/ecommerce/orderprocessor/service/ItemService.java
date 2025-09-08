package com.ecommerce.orderprocessor.service;

import com.ecommerce.orderprocessor.entity.Item;
import com.ecommerce.orderprocessor.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

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
        return itemRepository.save(item);
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