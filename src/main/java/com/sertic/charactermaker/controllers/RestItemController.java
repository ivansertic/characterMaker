package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.ItemDto;
import com.sertic.charactermaker.mapper.ItemMapper;
import com.sertic.charactermaker.model.Character;
import com.sertic.charactermaker.model.Item;
import com.sertic.charactermaker.services.CharacterService;
import com.sertic.charactermaker.services.ItemService;
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
public class RestItemController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemMapper itemMapper;

    public static final Logger logger = LoggerFactory.getLogger(RestCharacterController.class);

    //Create Item
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/item", method = RequestMethod.POST)
    public ResponseEntity<String> createItem(@PathVariable("externalUserId") UUID externalUserId,
                                             @PathVariable("externalCharacterId")UUID externalCharacterId,
                                             @RequestBody ItemDto dto){
        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            final Item item = itemMapper.createEntity(dto);

            item.setCharacter(character);
            character.getItems().add(item);

            itemService.create(item);

            return ResponseEntity.ok().build();
        }
    }

    //Update Item
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/item/{externalItemId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateItem(@PathVariable("externalUserId")UUID externalUserId,
                                             @PathVariable("externalCharacterId")UUID externalCharacterId,
                                             @PathVariable("externalItemId")UUID externalItemId,
                                             @RequestBody ItemDto dto){

        final Item item = itemService.getItemFromUserAndCharacter(externalUserId,externalCharacterId,externalItemId);

        if(item == null){
            return ResponseEntity.notFound().build();
        }else{
            itemMapper.update(item, dto);
            itemService.update(externalItemId, item);
            return ResponseEntity.ok().build();
        }
    }

    //Get All Items
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/item", method = RequestMethod.GET)
    public ResponseEntity<List<ItemDto>> getAllItems(@PathVariable("externalUserId")UUID externalUserId,
                                                     @PathVariable("externalCharacterId")UUID externalCharacterId){
        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);
        final List<Item> items = new LinkedList<>();

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            items.addAll(itemService.getAllItems(externalCharacterId));
        }

        final List<ItemDto> response = items.stream().map(item -> itemMapper.toDto(item)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    //Get Single Item
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/item/{externalItemId}", method = RequestMethod.GET)
    public ResponseEntity<ItemDto> getItem(@PathVariable("externalUserId")UUID externalUserId,
                                           @PathVariable("externalCharacterId")UUID externalCharacterId,
                                           @PathVariable("externalItemId")UUID externalItemId){
        final Item item = itemService.getItemFromUserAndCharacter(externalUserId,externalCharacterId,externalItemId);

        if( item == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(itemMapper.toDto(item));
        }
    }

    //Delete Item
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{externalUserId}/character/{externalCharacterId}/item/{externalItemId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteItem(@PathVariable("externalUserId")UUID externalUserId,
                                             @PathVariable("externalCharacterId")UUID externalCharacterId,
                                             @PathVariable("externalItemId")UUID externalItemId){
        final Item item = itemService.getItemFromUserAndCharacter(externalUserId,externalCharacterId,externalItemId);

        if(item == null){
            return ResponseEntity.notFound().build();
        }else{
            itemService.deleteByExternalId(externalItemId);
            return ResponseEntity.ok().build();
        }
    }



}
