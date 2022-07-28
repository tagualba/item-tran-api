package com.biller.itemtran.adapter;

import com.biller.itemtran.model.domain.Item;
import com.biller.itemtran.model.dtos.ItemDto;
import com.biller.itemtran.services.ItemService;
import com.biller.itemtran.translators.ItemTranslator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemAdapter {

    private final ItemService itemService;
    private final ItemTranslator itemTranslator;

    public ItemAdapter(ItemService itemService,
                       ItemTranslator itemTranslator){
        this.itemService = itemService;
        this.itemTranslator = itemTranslator;
    }
    public ItemDto createItem(ItemDto request) {
        Item item = itemTranslator.toDomain(request);
        item = itemService.createItem(item);
        return itemTranslator.toDto(item);
    }

    public ItemDto get(Long id) {
        Item item = itemService.find(id);
        return item != null ? itemTranslator.toDto(item) : null;
    }

    @Transactional(readOnly=true)
    public List<ItemDto> searchByName(String name) {
        List<Item> items = itemService.searchByName(name);
         items = itemService.searchByName(name);
         items = itemService.searchByName(name);
        return items != null ? items.stream().map(itemTranslator::toDto).collect(Collectors.toList()): null;
    }
}
