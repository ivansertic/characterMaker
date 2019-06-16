package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.CharacterDto;
import com.sertic.charactermaker.mapper.CharacterMapper;
import com.sertic.charactermaker.model.Character;
import com.sertic.charactermaker.model.CharacterClass;
import com.sertic.charactermaker.model.Race;
import com.sertic.charactermaker.model.Users;
import com.sertic.charactermaker.services.CharacterClassService;
import com.sertic.charactermaker.services.CharacterService;
import com.sertic.charactermaker.services.RaceService;
import com.sertic.charactermaker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class RestCharacterController {

    @Autowired
    private CharacterClassService characterClassService;

    @Autowired
    private RaceService raceService;

    @Autowired
    private CharacterService characterService;

    @Autowired
    private UserService userService;

    @Autowired
    private CharacterMapper characterMapper;

    //CreateCharacter
    @RequestMapping(value = "/{externalUserId}/character", method = RequestMethod.POST)
    public ResponseEntity<String> createCharacter(@PathVariable("externalUserId") UUID externalUserId,
                                                  @RequestBody CharacterDto dto){
        final Users user = userService.getUserBYExternalId(externalUserId);

        CharacterClass characterClass = characterClassService.getCharacterClassById(dto.getCharacterClassIdDto());

        Race race = raceService.getRaceById(dto.getRaceIdDto());

        if(user==null || characterClass == null || race == null){
            return ResponseEntity.notFound().build();
        }else{
            final Character character = characterMapper.createEntity(dto);

            character.setUser(user);
            user.addCharacter(character);

            character.setRace(race);
            race.getCharacters().add(character);

            character.setCharacterClass(characterClass);
            characterClass.getCharacters().add(character);

            characterService.createCharacter(character);

            return ResponseEntity.ok().build();

        }
    }

    //Test
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<List<CharacterDto>> getCharacterOfRace(){
        final List<Character> characters = new LinkedList<>();

        characters.addAll(characterService.getCharacterOfARace(2L));

        final List<CharacterDto> response = characters.stream().map(character -> characterMapper.toDot(character)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }
}
