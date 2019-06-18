package com.sertic.charactermaker.mapper;

import com.sertic.charactermaker.dto.UserDto;
import com.sertic.charactermaker.model.Users;
import com.sertic.charactermaker.util.Md5Hash;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Component
public class UserMapper {

    public void update(Users entity, UserDto dto) throws NoSuchAlgorithmException{
        entity.setUsername(dto.getUsername());
        entity.setPassword(Md5Hash.hashPassword(dto.getPassword()));
    }

    public UserDto toDto(Users entity){
        UserDto dto = new UserDto();
        dto.setPassword(entity.getPassword());
        dto.setUsername(entity.getUsername());
        return dto;
    }

    public Users createEntity(UserDto dto) throws NoSuchAlgorithmException{
        Users entity = new Users();
        entity.setExternalUserId(UUID.randomUUID());
        update(entity,dto);
        return entity;
    }
}
