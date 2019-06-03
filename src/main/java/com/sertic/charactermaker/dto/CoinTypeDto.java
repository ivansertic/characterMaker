package com.sertic.charactermaker.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CoinTypeDto {

    private Long idDto;

    private UUID externalCoinTypeIdDto;

    private String name;

    private Set<CoinDto> coinDtoSet = new HashSet<>();


    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalCoinTypeIdDto() {
        return externalCoinTypeIdDto;
    }

    public void setExternalCoinTypeIdDto(UUID externalCoinTypeIdDto) {
        this.externalCoinTypeIdDto = externalCoinTypeIdDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CoinDto> getCoinDtoSet() {
        return coinDtoSet;
    }

    public void setCoinDtoSet(Set<CoinDto> coinDtoSet) {
        this.coinDtoSet = coinDtoSet;
    }
}
