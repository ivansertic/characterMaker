package com.sertic.charactermaker.dto;

import java.util.UUID;

public class ItemDto {

    private Long idDto;

    private UUID externalItemIdDto;

    private String nameDto;

    private Long amountDto;

    private CharacterDto characterDto;


    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalItemIdDto() {
        return externalItemIdDto;
    }

    public void setExternalItemIdDto(UUID externalItemIdDto) {
        this.externalItemIdDto = externalItemIdDto;
    }

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
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
