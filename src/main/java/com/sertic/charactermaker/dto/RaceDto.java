package com.sertic.charactermaker.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class RaceDto {

    private Long idDto;

    private UUID externalRaceIdDto;

    private String name;

    private Set<CharacterDto> characterDtoSet = new HashSet<>();

    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalRaceIdDto() {
        return externalRaceIdDto;
    }

    public void setExternalRaceIdDto(UUID externalRaceIdDto) {
        this.externalRaceIdDto = externalRaceIdDto;
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
