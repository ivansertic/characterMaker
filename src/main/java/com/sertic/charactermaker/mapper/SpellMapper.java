package com.sertic.charactermaker.mapper;

import com.sertic.charactermaker.dto.SpellDto;
import com.sertic.charactermaker.model.Spell;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SpellMapper {

    public void update(Spell entity, SpellDto dto){
        entity.setDescription(dto.getDesriptionDto());
        entity.setName(dto.getNameDto());
        entity.setSpellLevel(dto.getSpellLevelDto());
        entity.setType(dto.getTypeDto());
    }

    public SpellDto toDto(Spell entity){
        SpellDto dto = new SpellDto();
        dto.setDesriptionDto(entity.getDescription());
        dto.setNameDto(entity.getName());
        dto.setSpellLevelDto(entity.getSpellLevel());
        dto.setTypeDto(entity.getType());
        dto.setIdDto(entity.getId());
        dto.setExternalSpellIdDto(entity.getExternalSpellId());

        return dto;
    }


    public Spell createEntity(SpellDto dto){
        Spell entity = new Spell();
        entity.setExternalSpellId(UUID.randomUUID());
        update(entity, dto);
        return entity;
    }
}
