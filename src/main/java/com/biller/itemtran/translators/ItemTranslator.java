package com.biller.itemtran.translators;

import com.biller.itemtran.model.domain.Item;
import com.biller.itemtran.model.dtos.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemTranslator {
    public Item toDomain(ItemDto request) {
        return Item.newBuilder()
                .withBarCode(request.getBarCode())
                .withName(request.getName())
                .withShortName(request.getShortName())
                .withQuantity(request.getQuantity())
                .withAmount(request.getAmount())
                .build();
    }

    public ItemDto toDto(Item request) {
        return ItemDto.newBuilder()
                .withBarCode(request.getBarCode())
                .withName(request.getName())
                .withShortName(request.getShortName())
                .withQuantity(request.getQuantity())
                .withAmount(request.getAmount())
                .build();
    }
}
