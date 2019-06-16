package com.sertic.charactermaker.mapper;

import com.sertic.charactermaker.dto.CoinDto;
import com.sertic.charactermaker.model.Coin;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CoinMapper {

    public void update(Coin entity, CoinDto dto){
        entity.setAmount(dto.getAmmountDto());
        entity.setCoinType(dto.getCoinTypeDto());
    }

    public CoinDto toDto(Coin entity){
        CoinDto dto = new CoinDto();
        dto.setAmmountDto(entity.getAmount());
        dto.setIdDto(entity.getId());
        dto.setExternalCoinIdDto(entity.getExternalId());
        dto.setCoinTypeDto(entity.getCoinType());

        return dto;
    }

    public Coin createEntity(CoinDto dto){
        Coin entity = new Coin();
        entity.setExternalId(UUID.randomUUID());
        update(entity,dto);

        return entity;
    }
}
