package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.UserDto;
import com.sertic.charactermaker.model.Users;
import com.sertic.charactermaker.services.UserService;
import com.sertic.charactermaker.util.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class RestLoginController {

    @Autowired
    private UserService userService;

    public static final Logger logger = LoggerFactory.getLogger(RestCharacterController.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> logIn(@Valid @RequestBody UserDto dto){
        try {
            Users user = userService.getUserByUsernamAndPassword(dto.getUsername(), Md5Hash.hashPassword(dto.getPassword()));
            return ResponseEntity.ok().body(Map.of("token",user.getExternalUserId().toString()));
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error","Hashing went wrong"));
        }

    }
}
