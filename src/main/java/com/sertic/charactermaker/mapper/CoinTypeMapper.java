package com.sertic.charactermaker.mapper;

import com.sertic.charactermaker.dto.CoinTypeDto;
import com.sertic.charactermaker.model.CoinType;
import org.springframework.stereotype.Component;

@Component
public class CoinTypeMapper {

    private CoinMapper coinMapper;

    public CoinTypeMapper(){
        this.coinMapper = new CoinMapper();
    }


    public CoinTypeMapper(CoinMapper coinMapper) {
        this.coinMapper = coinMapper;
    }

    public CoinTypeDto toDto(CoinType entity){
        CoinTypeDto dto = new CoinTypeDto();
        dto.setName(entity.getName());
        dto.setExternalCoinTypeIdDto(entity.getExternalCoinTypeId());
        dto.setIdDto(entity.getId());

        return dto;
    }
}
