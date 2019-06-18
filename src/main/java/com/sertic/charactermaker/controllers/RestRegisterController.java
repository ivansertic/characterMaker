package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.UserDto;
import com.sertic.charactermaker.mapper.UserMapper;
import com.sertic.charactermaker.model.Users;
import com.sertic.charactermaker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RestRegisterController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> register(@Valid @RequestBody UserDto dto){
        try{
            Users user = userMapper.createEntity(dto);
            userService.createUser(user);

            return ResponseEntity.ok().build();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error","Hashing went wrong"));
        }
    }
}
