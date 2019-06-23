package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.SpellDto;
import com.sertic.charactermaker.mapper.SpellMapper;
import com.sertic.charactermaker.model.Character;
import com.sertic.charactermaker.model.Spell;
import com.sertic.charactermaker.services.CharacterService;
import com.sertic.charactermaker.services.SpellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class RestSpellController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private SpellService spellService;

    @Autowired
    private SpellMapper spellMapper;

    public static final Logger logger = LoggerFactory.getLogger(RestCharacterController.class);


    //Create Spell
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="{externalUserId}/character/{externalCharacterId}/spell", method = RequestMethod.POST)
    public ResponseEntity<String> createSpell(@PathVariable("externalUserId")UUID externalUserId,
                                              @PathVariable("externalCharacterId")UUID externalCharacterId,
                                              @RequestBody SpellDto dto){
        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            final Spell spell = spellMapper.createEntity(dto);

            spell.setCharacter(character);
            character.getSpells().add(spell);

            spellService.create(spell);

            return ResponseEntity.ok().build();
        }
    }

    //Update Spell
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "{externalUserId}/character/{externalCharacterId}/spell/{externalSpellId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateSpell(@PathVariable("externalUserId")UUID externalUserId,
                                              @PathVariable("externalCharacterId")UUID externalCharacterId,
                                              @PathVariable("externalSpellId")UUID externalSpellId,
                                              @RequestBody SpellDto dto){
        final Spell spell = spellService.getSpellFromUserAndCharacter(externalUserId,externalCharacterId,externalSpellId);

        if(spell == null){
            return ResponseEntity.notFound().build();
        }else{
            spellMapper.update(spell,dto);
            spellService.update(externalSpellId,spell);
            return ResponseEntity.ok().build();
        }
    }


    //GetAllSpells
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="{externalUserId}/character/{externalCharacterId}/spell", method = RequestMethod.GET)
    public ResponseEntity<List<SpellDto>> getAllSpells(@PathVariable("externalUserId")UUID externalUserId,
                                                       @PathVariable("externalCharacterId")UUID externalCharacterId){

        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);
        final List<Spell> spells = new LinkedList<>();

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            spells.addAll(spellService.getAllSpells(externalCharacterId));
        }

        final List<SpellDto> response = spells.stream().map(spell -> spellMapper.toDto(spell)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    //Get Spell
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "{externalUserId}/character/{externalCharacterId}/spell/{externalSpellId}", method = RequestMethod.GET)
    public ResponseEntity<SpellDto> getSpell(@PathVariable("externalUserId")UUID externalUserId,
                                             @PathVariable("externalCharacterId")UUID externalCharacterId,
                                             @PathVariable("externalSpellId")UUID externalSpellId){

        final Spell spell = spellService.getSpellFromUserAndCharacter(externalUserId,externalCharacterId,externalSpellId);

        if(spell == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(spellMapper.toDto(spell));
        }
    }


    //Delete Spell
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "{externalUserId}/character/{externalCharacterId}/spell/{externalSpellId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSpell(@PathVariable("externalUserId")UUID externalUserId,
                                              @PathVariable("externalCharacterId")UUID externalCharacterId,
                                              @PathVariable("externalSpellId")UUID externalSpellId){

        final Spell spell = spellService.getSpellFromUserAndCharacter(externalUserId,externalCharacterId,externalSpellId);

        if(spell == null){
            return ResponseEntity.notFound().build();
        }else{
            spellService.deleteByExternalSpellId(externalSpellId);
            return ResponseEntity.ok().build();
        }
    }
}
