package com.sertic.charactermaker.dto;

import java.util.UUID;

public class WeaponDto {

    private Long idDto;

    private UUID externalWeaponIdDto;

    private String name;

    private Long attackBonus;

    private String damageType;

    private CharacterDto characterDto;

    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalWeaponIdDto() {
        return externalWeaponIdDto;
    }

    public void setExternalWeaponIdDto(UUID externalWeaponIdDto) {
        this.externalWeaponIdDto = externalWeaponIdDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(Long attackBonus) {
        this.attackBonus = attackBonus;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public CharacterDto getCharacterDto() {
        return characterDto;
    }

    public void setCharacterDto(CharacterDto characterDto) {
        this.characterDto = characterDto;
    }
}
