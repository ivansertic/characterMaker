package com.sertic.charactermaker.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CharacterDto {

    private Long idDto;

    private UUID externalCharacterIdDto;

    private String nameDto;

    private String characterClassDto;

    private String raceDto;

    private UserDto userDto;

    private CharacterStatisticDto characterStatisticDto;

    private Set<CoinDto> coinDtoSet = new HashSet<>();

    private Set<ItemDto> itemDtoSet = new HashSet<>();

    private Set<SkillDto> skillDtoSet = new HashSet<>();

    private Set <SpellDto> spellDtoSet = new HashSet<>();

    private Set <WeaponDto> weaponDtoSet = new HashSet<>();

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

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public String getCharacterClassDto() {
        return characterClassDto;
    }

    public void setCharacterClassDto(String characterClassDto) {
        this.characterClassDto = characterClassDto;
    }

    public String getRaceDto() {
        return raceDto;
    }

    public void setRaceDto(String raceDto) {
        this.raceDto = raceDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public CharacterStatisticDto getCharacterStatisticDto() {
        return characterStatisticDto;
    }

    public void setCharacterStatisticDto(CharacterStatisticDto characterStatisticDto) {
        this.characterStatisticDto = characterStatisticDto;
    }

    public Set<CoinDto> getCoinDtoSet() {
        return coinDtoSet;
    }

    public void setCoinDtoSet(Set<CoinDto> coinDtoSet) {
        this.coinDtoSet = coinDtoSet;
    }

    public Set<ItemDto> getItemDtoSet() {
        return itemDtoSet;
    }

    public void setItemDtoSet(Set<ItemDto> itemDtoSet) {
        this.itemDtoSet = itemDtoSet;
    }

    public Set<SkillDto> getSkillDtoSet() {
        return skillDtoSet;
    }

    public void setSkillDtoSet(Set<SkillDto> skillDtoSet) {
        this.skillDtoSet = skillDtoSet;
    }

    public Set<SpellDto> getSpellDtoSet() {
        return spellDtoSet;
    }

    public void setSpellDtoSet(Set<SpellDto> spellDtoSet) {
        this.spellDtoSet = spellDtoSet;
    }

    public Set<WeaponDto> getWeaponDtoSet() {
        return weaponDtoSet;
    }

    public void setWeaponDtoSet(Set<WeaponDto> weaponDtoSet) {
        this.weaponDtoSet = weaponDtoSet;
    }
}
