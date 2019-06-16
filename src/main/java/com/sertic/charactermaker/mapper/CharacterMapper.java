package com.sertic.charactermaker.mapper;

import com.sertic.charactermaker.dto.CharacterDto;
import com.sertic.charactermaker.model.Character;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CharacterMapper {

    private CoinMapper coinMapper;

    private ItemMapper itemMapper;

    private SpellMapper spellMapper;

    private WeaponMapper weaponMapper;

    public CharacterMapper(){
        this.coinMapper = new CoinMapper();
        this.itemMapper = new ItemMapper();
        this.spellMapper = new SpellMapper();
        this.weaponMapper = new WeaponMapper();
    }

    public CharacterMapper(CoinMapper coinMapper, ItemMapper itemMapper, SpellMapper spellMapper, WeaponMapper weaponMapper) {
        this.coinMapper = coinMapper;
        this.itemMapper = itemMapper;
        this.spellMapper = spellMapper;
        this.weaponMapper = weaponMapper;
    }

    public void update(Character entity, CharacterDto dto){
        entity.setName(dto.getNameDto());
        entity.setArmourClass(dto.getArmourClassDto());
        entity.setInitiative(dto.getInitiativeDto());
        entity.setSpeed(dto.getSpeedDto());
        entity.setHitPoints(dto.getHitPointsDto());
        entity.setCharacterLevel(dto.getCharacterLevelDto());
        entity.setExpiriencePoints(dto.getExpiriencePointsDto());
        entity.setStrength(dto.getStrengthDto());
        entity.setDexterity(dto.getDexterityDto());
        entity.setConstitution(dto.getConstitutionDto());
        entity.setIntelligence(dto.getIntelligenceDto());
        entity.setWisdom(dto.getWisdomDto());
        entity.setCharisma(dto.getCharismaDto());
        entity.setCharacterClassId(dto.getCharacterClassIdDto());
        entity.setRaceId(dto.getRaceIdDto());
    }

    public CharacterDto toDot(Character entity){
        CharacterDto dto = new CharacterDto();
        dto.setNameDto(entity.getName());
        dto.setArmourClassDto(entity.getArmourClass());
        dto.setInitiativeDto(entity.getInitiative());
        dto.setSpeedDto(entity.getSpeed());
        dto.setHitPointsDto(entity.getHitPoints());
        dto.setCharacterLevelDto(entity.getCharacterLevel());
        dto.setExpiriencePointsDto(entity.getExpiriencePoints());
        dto.setStrengthDto(entity.getStrength());
        dto.setDexterityDto(entity.getDexterity());
        dto.setConstitutionDto(entity.getConstitution());
        dto.setIntelligenceDto(entity.getIntelligence());
        dto.setWisdomDto(entity.getWisdom());
        dto.setCharismaDto(entity.getCharisma());
        dto.setExternalCharacterIdDto(entity.getExternalCharacterId());
        dto.setId(entity.getId());
        dto.setCharacterClassIdDto(entity.getCharacterClassId());
        dto.setRaceIdDto(entity.getRaceId());

        return dto;
    }

    public Character createEntity(CharacterDto dto){
        Character entity = new Character();
        entity.setExternalCharacterId(UUID.randomUUID());
        update(entity,dto);

        return entity;
    }
}
