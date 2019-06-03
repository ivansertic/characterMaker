package com.sertic.charactermaker.mapper;

import com.sertic.charactermaker.dto.CharacterClassDto;
import com.sertic.charactermaker.model.CharacterClass;
import org.springframework.stereotype.Component;

@Component
public class CharacterClassMapper {

    private CharacterMapper characterMapper;

    public CharacterClassMapper(){
        this.characterMapper = new CharacterMapper();
    }

    public CharacterClassMapper(CharacterMapper characterMapper){
        this.characterMapper = new CharacterMapper();
    }

    public CharacterClassDto toDto(CharacterClass entity){
        CharacterClassDto dto = new CharacterClassDto();
        dto.setName(entity.getName());
        dto.setExternalCharacterClassIdDto(entity.getExternalCharacterClassId());
        dto.setIdDto(entity.getId());

        return dto;
    }
}
