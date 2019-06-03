package com.sertic.charactermaker.mapper;

import com.sertic.charactermaker.dto.ItemDto;
import com.sertic.charactermaker.model.Item;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ItemMapper {

    public void update(Item entity, ItemDto dto){
        entity.setAmount(dto.getAmountDto());
        entity.setName(dto.getNameDto());
    }

    public ItemDto toDto(Item entity){
        ItemDto dto = new ItemDto();
        dto.setAmountDto(entity.getAmount());
        dto.setNameDto(entity.getName());
        dto.setIdDto(entity.getId());
        dto.setExternalItemIdDto(entity.getExternalItemId());
        return dto;
    }

    public Item createEntity(ItemDto dto){
        Item entity = new Item();
        entity.setExternalItemId(UUID.randomUUID());
        update(entity,dto);

        return entity;
    }
}
