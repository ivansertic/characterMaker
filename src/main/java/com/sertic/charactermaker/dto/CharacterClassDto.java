package com.sertic.charactermaker.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CharacterClassDto {

    private Long idDto;

    private UUID externalCharacterClassIdDto;

    private String name;

    private Set<CharacterDto> characterDtoSet = new HashSet<>();


    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalCharacterClassIdDto() {
        return externalCharacterClassIdDto;
    }

    public void setExternalCharacterClassIdDto(UUID externalCharacterClassIdDto) {
        this.externalCharacterClassIdDto = externalCharacterClassIdDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CharacterDto> getCharacterDtoSet() {
        return characterDtoSet;
    }

    public void setCharacterDtoSet(Set<CharacterDto> characterDtoSet) {
        this.characterDtoSet = characterDtoSet;
    }
}
