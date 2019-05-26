package com.sertic.charactermaker.dto;

import java.util.UUID;

public class CharacterStatisticDto {

    private Long idDto;

    private UUID externalCharacterIdDto;

    private Long armourClassDto;

    private Long initiativeDto;

    private Long speedDto;

    private Long hitPointsDto;

    private Long characterLevelDto;

    private Long expiriencePointsDto;

    private CharacterDto characterDto;


    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalCharacterIdDto() {
        return externalCharacterIdDto;
    }

    public void setExternalCharacterIdDto(UUID externalCharacterIdDto) {
        this.externalCharacterIdDto = externalCharacterIdDto;
    }

    public Long getArmourClassDto() {
        return armourClassDto;
    }

    public void setArmourClassDto(Long armourClassDto) {
        this.armourClassDto = armourClassDto;
    }

    public Long getInitiativeDto() {
        return initiativeDto;
    }

    public void setInitiativeDto(Long initiativeDto) {
        this.initiativeDto = initiativeDto;
    }

    public Long getSpeedDto() {
        return speedDto;
    }

    public void setSpeedDto(Long speedDto) {
        this.speedDto = speedDto;
    }

    public Long getHitPointsDto() {
        return hitPointsDto;
    }

    public void setHitPointsDto(Long hitPointsDto) {
        this.hitPointsDto = hitPointsDto;
    }

    public Long getCharacterLevelDto() {
        return characterLevelDto;
    }

    public void setCharacterLevelDto(Long characterLevelDto) {
        this.characterLevelDto = characterLevelDto;
    }

    public Long getExpiriencePointsDto() {
        return expiriencePointsDto;
    }

    public void setExpiriencePointsDto(Long expiriencePointsDto) {
        this.expiriencePointsDto = expiriencePointsDto;
    }

    public CharacterDto getCharacterDto() {
        return characterDto;
    }

    public void setCharacterDto(CharacterDto characterDto) {
        this.characterDto = characterDto;
    }
}
