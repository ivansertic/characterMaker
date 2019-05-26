package com.sertic.charactermaker.dto;

import java.util.UUID;

public class WeaponDto {

    private Long idDto;

    private UUID externalWeaponIdDto;

    private String nameDto;

    private Long attackBonusDto;

    private String damageTypeDto;

    private Boolean equipDto;

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

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public Long getAttackBonusDto() {
        return attackBonusDto;
    }

    public void setAttackBonusDto(Long attackBonusDto) {
        this.attackBonusDto = attackBonusDto;
    }

    public String getDamageTypeDto() {
        return damageTypeDto;
    }

    public void setDamageTypeDto(String damageTypeDto) {
        this.damageTypeDto = damageTypeDto;
    }

    public Boolean getEquipDto() {
        return equipDto;
    }

    public void setEquipDto(Boolean equipDto) {
        this.equipDto = equipDto;
    }

    public CharacterDto getCharacterDto() {
        return characterDto;
    }

    public void setCharacterDto(CharacterDto characterDto) {
        this.characterDto = characterDto;
    }
}
