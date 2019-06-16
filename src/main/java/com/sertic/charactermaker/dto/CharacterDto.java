package com.sertic.charactermaker.dto;

import java.util.UUID;

public class CharacterDto {

    private Long id;

    private UserDto userDto;

    private UUID externalCharacterIdDto;


    //Character Info
    private String nameDto;

    private RaceDto raceDto;

    private CharacterClassDto characterClassDto;

    //Character statistics
    private Long armourClassDto;

    private Long initiativeDto;

    private Long speedDto;

    private Long hitPointsDto;

    private Long characterLevelDto;

    private Long expiriencePointsDto;


    // Skills
    private Long strengthDto;

    private Long dexterityDto;

    private Long constitutionDto;

    private Long intelligenceDto;

    private Long wisdomDto;

    private Long charismaDto;

    private Long characterClassIdDto;

    private Long raceIdDto;



    //Basic Table Getters And Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public UUID getExternalCharacterIdDto() {
        return externalCharacterIdDto;
    }

    public void setExternalCharacterIdDto(UUID externalCharacterIdDto) {
        this.externalCharacterIdDto = externalCharacterIdDto;
    }



    //Character Info Getters And Setters
    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public RaceDto getRaceDto() {
        return raceDto;
    }

    public void setRaceDto(RaceDto raceDto) {
        this.raceDto = raceDto;
    }

    public CharacterClassDto getCharacterClassDto() {
        return characterClassDto;
    }

    public void setCharacterClassDto(CharacterClassDto characterClassDto) {
        this.characterClassDto = characterClassDto;
    }

    public Long getArmourClassDto() {
        return armourClassDto;
    }



    //Character Statistics Getters And Setters
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



    //Character Skills Getters And Setters

    public Long getStrengthDto() {
        return strengthDto;
    }

    public void setStrengthDto(Long strengthDto) {
        this.strengthDto = strengthDto;
    }

    public Long getDexterityDto() {
        return dexterityDto;
    }

    public void setDexterityDto(Long dexterityDto) {
        this.dexterityDto = dexterityDto;
    }

    public Long getConstitutionDto() {
        return constitutionDto;
    }

    public void setConstitutionDto(Long constitutionDto) {
        this.constitutionDto = constitutionDto;
    }

    public Long getIntelligenceDto() {
        return intelligenceDto;
    }

    public void setIntelligenceDto(Long intelligenceDto) {
        this.intelligenceDto = intelligenceDto;
    }

    public Long getWisdomDto() {
        return wisdomDto;
    }

    public void setWisdomDto(Long wisdomDto) {
        this.wisdomDto = wisdomDto;
    }

    public Long getCharismaDto() {
        return charismaDto;
    }

    public void setCharismaDto(Long charismaDto) {
        this.charismaDto = charismaDto;
    }

    public Long getCharacterClassIdDto() {
        return characterClassIdDto;
    }

    public void setCharacterClassIdDto(Long characterClassIdDto) {
        this.characterClassIdDto = characterClassIdDto;
    }

    public Long getRaceIdDto() {
        return raceIdDto;
    }

    public void setRaceIdDto(Long raceIdDto) {
        this.raceIdDto = raceIdDto;
    }
}
