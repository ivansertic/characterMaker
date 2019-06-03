package com.sertic.charactermaker.mapper;

import com.sertic.charactermaker.dto.RaceDto;
import com.sertic.charactermaker.model.Race;
import org.springframework.stereotype.Component;

@Component
public class RaceMapper {

    private CharacterMapper characterMapper;

    public RaceMapper(){
        this.characterMapper = new CharacterMapper();
    }

    public RaceMapper(CharacterMapper characterMapper){
        this.characterMapper = characterMapper;
    }

    public RaceDto toDto(Race entity){
        RaceDto dto = new RaceDto();
        dto.setName(entity.getName());
        dto.setIdDto(entity.getId());
        dto.setExternalRaceIdDto(entity.getExternalRaceId());

        return dto;
    }
}
