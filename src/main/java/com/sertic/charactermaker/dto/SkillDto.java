package com.sertic.charactermaker.dto;

import java.util.UUID;

public class SkillDto {

    private Long idDto;

    private UUID externalSkillIdDto;

    private String nameDto;

    private Long skillPoints;

    private CharacterDto characterDto;

    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalSkillIdDto() {
        return externalSkillIdDto;
    }

    public void setExternalSkillIdDto(UUID externalSkillIdDto) {
        this.externalSkillIdDto = externalSkillIdDto;
    }

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public Long getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(Long skillPoints) {
        this.skillPoints = skillPoints;
    }

    public CharacterDto getCharacterDto() {
        return characterDto;
    }

    public void setCharacterDto(CharacterDto characterDto) {
        this.characterDto = characterDto;
    }
}
