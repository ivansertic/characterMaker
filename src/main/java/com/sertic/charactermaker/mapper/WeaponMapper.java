package com.sertic.charactermaker.mapper;

import com.sertic.charactermaker.dto.WeaponDto;
import com.sertic.charactermaker.model.Weapon;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WeaponMapper {

    public void update(Weapon entity, WeaponDto dto){
        entity.setAttackBonus(dto.getAttackBonus());
        entity.setDamageType(dto.getDamageType());
        entity.setName(dto.getName());
    }

    public WeaponDto toDto(Weapon entity){
        WeaponDto dto = new WeaponDto();
        dto.setAttackBonus(entity.getAttackBonus());
        dto.setDamageType(entity.getDamageType());
        dto.setName(entity.getName());
        dto.setIdDto(entity.getId());
        dto.setExternalWeaponIdDto(entity.getExternalWeaponId());

        return dto;
    }

    public Weapon createEntity(WeaponDto dto){
        Weapon entity = new Weapon();
        entity.setExternalWeaponId(UUID.randomUUID());
        update(entity,dto);

        return entity;
    }
}
