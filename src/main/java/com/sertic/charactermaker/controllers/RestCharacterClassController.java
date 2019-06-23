package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.CharacterClassDto;
import com.sertic.charactermaker.mapper.CharacterClassMapper;
import com.sertic.charactermaker.model.CharacterClass;
import com.sertic.charactermaker.services.CharacterClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/class")
public class RestCharacterClassController {

    @Autowired
    private CharacterClassService characterClassService;

    @Autowired
    private CharacterClassMapper characterClassMapper;

    public static final Logger logger = LoggerFactory.getLogger(RestCharacterController.class);

    //ReturnAllClasses
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CharacterClassDto>> getAllClasses(){
        final List<CharacterClass> classes = new LinkedList<>();

        classes.addAll(characterClassService.getAllCharacterClasses());

        final List<CharacterClassDto> response = classes.stream().map(characterClass -> characterClassMapper.toDto(characterClass)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    //RetriveOneClass
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public ResponseEntity<CharacterClassDto> getClass (@PathVariable("id")Long id){

        final CharacterClass characterClass = characterClassService.getCharacterClassById(id);

        if(characterClass == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(characterClassMapper.toDto(characterClass));
        }
    }
}
