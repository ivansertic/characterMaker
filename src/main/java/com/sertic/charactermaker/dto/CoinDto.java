package com.sertic.charactermaker.dto;

import java.util.UUID;

public class CoinDto {

    private Long idDto;

    private UUID externalCoinIdDto;


    private Long ammountDto;

    private CharacterDto characterDto;

    private String coinTypeDto;


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

    public Long getAmmountDto() {
        return ammountDto;
    }

    public void setAmmountDto(Long ammountDto) {
        this.ammountDto = ammountDto;
    }

    public CharacterDto getCharacterDto() {
        return characterDto;
    }

    public void setCharacterDto(CharacterDto characterDto) {
        this.characterDto = characterDto;
    }
    
}
