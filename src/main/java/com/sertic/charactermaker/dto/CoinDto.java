package com.sertic.charactermaker.dto;

import java.util.UUID;

public class CoinDto {

    private Long idDto;

    private UUID externalCoinIdDto;

    private String coinTypeDto;

    private Long amountDto;

    private CharacterDto characterDto;

    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalCoinIdDto() {
        return externalCoinIdDto;
    }

    public void setExternalCoinIdDto(UUID externalCoinIdDto) {
        this.externalCoinIdDto = externalCoinIdDto;
    }

    public String getCoinTypeDto() {
        return coinTypeDto;
    }

    public void setCoinTypeDto(String coinTypeDto) {
        this.coinTypeDto = coinTypeDto;
    }

    public Long getAmountDto() {
        return amountDto;
    }

    public void setAmountDto(Long amountDto) {
        this.amountDto = amountDto;
    }

    public CharacterDto getCharacterDto() {
        return characterDto;
    }

    public void setCharacterDto(CharacterDto characterDto) {
        this.characterDto = characterDto;
    }
}
