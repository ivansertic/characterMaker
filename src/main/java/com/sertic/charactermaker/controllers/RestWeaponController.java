package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.WeaponDto;
import com.sertic.charactermaker.mapper.WeaponMapper;
import com.sertic.charactermaker.model.Character;
import com.sertic.charactermaker.model.Weapon;
import com.sertic.charactermaker.services.CharacterService;
import com.sertic.charactermaker.services.WeaponService;
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
public class RestWeaponController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private WeaponService weaponService;

    @Autowired
    private WeaponMapper weaponMapper;

    public static final Logger logger = LoggerFactory.getLogger(RestCharacterController.class);


    //Create a Weapon
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/weapon", method = RequestMethod.POST)
    public ResponseEntity<String> createWeapon(@PathVariable("externalUserId") UUID externalUserId,
                                               @PathVariable("externalCharacterId")UUID externalCharacterId,
                                               @RequestBody WeaponDto dto){
        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            final Weapon weapon = weaponMapper.createEntity(dto);

            weapon.setCharacter(character);
            character.getWeapons().add(weapon);

            weaponService.create(weapon);

            return ResponseEntity.ok().build();
        }
    }

    //Update Weapon
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/weapon/{externalWeaponId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateWeapon(@PathVariable("externalUserId")UUID externalUserId,
                                               @PathVariable("externalCharacterId")UUID externalCharacterId,
                                               @PathVariable("externalWeaponId")UUID externalWeaponId,
                                               @RequestBody WeaponDto dto){
        final Weapon weapon = weaponService.getWeaponFromUserAndCharacter(externalUserId,externalCharacterId,externalWeaponId);

        if(weapon == null){
            return ResponseEntity.notFound().build();
        }else{
            weaponMapper.update(weapon,dto);
            weaponService.update(externalWeaponId,weapon);
            return ResponseEntity.ok().build();
        }
    }

    //Get All Weapons
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/weapon",method = RequestMethod.GET)
    public ResponseEntity<List<WeaponDto>> getAllWeapons(@PathVariable("externalUserId")UUID externalUserId,
                                                         @PathVariable("externalCharacterId")UUID externalCharacterId){
        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);
        final List<Weapon> weapons = new LinkedList<>();

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            weapons.addAll(weaponService.getAllWeapons(externalCharacterId));
        }

        final List<WeaponDto> response = weapons.stream().map(weapon -> weaponMapper.toDto(weapon)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    //Get Single Weapon
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/weapon/{externalWeaponId}", method = RequestMethod.GET)
    public ResponseEntity<WeaponDto> getAWeapon(@PathVariable("externalUserId")UUID externalUserId,
                                                @PathVariable("externalCharacterId")UUID externalCharacterId,
                                                @PathVariable("externalWeaponId")UUID externalWeaponId){
        final Weapon weapon = weaponService.getWeaponFromUserAndCharacter(externalUserId,externalCharacterId,externalWeaponId);

        if(weapon == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(weaponMapper.toDto(weapon));
        }
    }

    //Delete Weapon
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/weapon/{externalWeaponId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteWeapon(@PathVariable("externalUserId")UUID externalUserId,
                                               @PathVariable("externalCharacterId")UUID externalCharacterId,
                                               @PathVariable("externalWeaponId")UUID externalWeaponId){
        final Weapon weapon = weaponService.getWeaponFromUserAndCharacter(externalUserId,externalCharacterId,externalWeaponId);

        if(weapon == null){
            return ResponseEntity.notFound().build();
        }else{
            weaponService.deleteByExternalId(externalWeaponId);
            return ResponseEntity.ok().build();
        }
    }
}
