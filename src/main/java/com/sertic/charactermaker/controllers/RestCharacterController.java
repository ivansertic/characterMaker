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

    //Update character
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCharacter(@PathVariable("externalUserId")UUID externalUserId,
                                                  @PathVariable("externalCharacterId")UUID externalCharacterId,
                                                  @RequestBody CharacterDto dto){
        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);

        CharacterClass characterClass = characterClassService.getCharacterClassById(dto.getCharacterClassIdDto());

        Race race = raceService.getRaceById(dto.getRaceIdDto());

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            characterClass.getCharacters().remove(character);
            race.getCharacters().remove(character);

            characterMapper.update(character, dto);

            character.setCharacterClass(characterClass);
            characterClass.getCharacters().add(character);

            character.setRace(race);
            race.getCharacters().add(character);

            characterService.updateCharacter(externalCharacterId, character);

            return ResponseEntity.ok().build();
        }
    }


    //Delete character
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCharacter(@PathVariable("externalUserId")UUID externalUserId,
                                                  @PathVariable("externalCharacterId")UUID externalCharacterId){
        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            characterService.deleteByExternalId(externalCharacterId);
            return ResponseEntity.ok().build();
        }
    }

    //Return all characters
    @RequestMapping(value = "/{externalUserId}/character", method = RequestMethod.GET)
    public ResponseEntity<List<CharacterDto>> getAllCharacters(@PathVariable("externalUserId")UUID externalUserId){

        final List<Character> characters = new LinkedList<>();

        if(characters == null){
            return ResponseEntity.notFound().build();
        }else{
            characters.addAll(characterService.getAllCharactersFromAUser(externalUserId));
        }

        final List<CharacterDto> response = characters.stream().map(character -> characterMapper.toDot(character)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    //Return one character
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}", method = RequestMethod.GET)
    public ResponseEntity<CharacterDto> getACharacter(@PathVariable("externalUserId")UUID externalUserId,
                                                      @PathVariable("externalCharacterId")UUID externalCharacterId){
        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(characterMapper.toDot(character));
        }
    }




    //Test
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<List<CharacterDto>> getCharacterOfRace(){
        final List<Character> characters = new LinkedList<>();

        characters.addAll(characterService.getCharacterOfARace(3L));

        final List<CharacterDto> response = characters.stream().map(character -> characterMapper.toDot(character)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }
}
