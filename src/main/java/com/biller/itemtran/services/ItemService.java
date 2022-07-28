package com.biller.itemtran.services;

import com.biller.itemtran.model.domain.Item;
import com.biller.itemtran.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item find(Long id){
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> searchByName(String name){
        return itemRepository.findByNameContaining(name).orElse(null);
    }


}
