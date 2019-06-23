package com.sertic.charactermaker.dto;

import java.util.UUID;

public class SpellDto {

    private Long idDto;

    private UUID externalSpellIdDto;

    private String nameDto;

    private String typeDto;

    private Long spellLevelDto;

    private CharacterDto characterDto;


    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalSpellIdDto() {
        return externalSpellIdDto;
    }

    public void setExternalSpellIdDto(UUID externalSpellIdDto) {
        this.externalSpellIdDto = externalSpellIdDto;
    }

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public String getTypeDto() {
        return typeDto;
    }

    public void setTypeDto(String typeDto) {
        this.typeDto = typeDto;
    }

    public Long getSpellLevelDto() {
        return spellLevelDto;
    }

    public void setSpellLevelDto(Long spellLevelDto) {
        this.spellLevelDto = spellLevelDto;
    }

    public CharacterDto getCharacterDto() {
        return characterDto;
    }

    public void setCharacterDto(CharacterDto characterDto) {
        this.characterDto = characterDto;
    }
}
