package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.CoinDto;
import com.sertic.charactermaker.mapper.CoinMapper;
import com.sertic.charactermaker.model.Character;
import com.sertic.charactermaker.model.Coin;
import com.sertic.charactermaker.services.CharacterService;
import com.sertic.charactermaker.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class RestCoinController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private CoinService coinService;

    @Autowired
    private CoinMapper coinMapper;


    //Create Coin
    @RequestMapping(value = "{externalUserId}/character/{externalCharacterId}/coin", method = RequestMethod.POST)
    public ResponseEntity<String> createCoin(@PathVariable("externalUserId") UUID externalUserId,
                                             @PathVariable("externalCharacterId")UUID externalCharacterId,
                                             @RequestBody CoinDto dto){

        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            final Coin coin = coinMapper.createEntity(dto);

            coin.setCharacter(character);
            character.getCoins().add(coin);

            coinService.create(coin);

            return ResponseEntity.ok().build();
        }
    }

    //Update Coin
    @RequestMapping(value = "{externalUserId}/character/{externalCharacterId}/coin/{externalCoinId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCoin(@PathVariable("externalUserId") UUID externalUserId,
                                             @PathVariable("externalCharacterId")UUID externalCharacterId,
                                             @PathVariable("externalCoinId")UUID externalCoinId,
                                             @RequestBody CoinDto dto){

        final Coin coin = coinService.getCoinFromUserAndCharacter(externalUserId,externalCharacterId,externalCoinId);

        if(coin == null){
            return ResponseEntity.notFound().build();
        }else{
            coinMapper.update(coin,dto);
            coinService.update(externalCoinId,coin);
            return ResponseEntity.ok().build();
        }
    }


    //Get All coins
    @RequestMapping(value = "{externalUserId}/character/{externalCharacterId}/coin", method = RequestMethod.GET)
    public ResponseEntity<List<CoinDto>> getAllCoins(@PathVariable("externalUserId") UUID externalUserId,
                                                     @PathVariable("externalCharacterId")UUID externalCharacterId){

        final Character character = characterService.GetCharacterFromUser(externalCharacterId,externalUserId);
        final List<Coin> coins = new LinkedList<>();

        if(character == null){
            return ResponseEntity.notFound().build();
        }else{
            coins.addAll(coinService.getAllCoinsOfACharacter(externalCharacterId));
        }

        final List<CoinDto> response = coins.stream().map(coin -> coinMapper.toDto(coin)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }


    //Get Single coin
    @RequestMapping(value = "{externalUserId}/character/{externalCharacterId}/coin/{externalCoinId}", method = RequestMethod.GET)
    public ResponseEntity<CoinDto> getCoin(@PathVariable("externalUserId") UUID externalUserId,
                                           @PathVariable("externalCharacterId")UUID externalCharacterId,
                                           @PathVariable("externalCoinId")UUID externalCoinId){

        final Coin coin = coinService.getCoinFromUserAndCharacter(externalUserId,externalCharacterId,externalCoinId);

        if(coin == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(coinMapper.toDto(coin));
        }
    }


    //Delete Coin
    @RequestMapping (value = "{externalUserId}/character/{externalCharacterId}/coin/{externalCoinId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCoin(@PathVariable("externalUserId") UUID externalUserId,
                                             @PathVariable("externalCharacterId")UUID externalCharacterId,
                                             @PathVariable("externalCoinId")UUID externalCoinId){

        final Coin coin = coinService.getCoinFromUserAndCharacter(externalUserId,externalCharacterId,externalCoinId);

        if(coin == null){
            return ResponseEntity.notFound().build();
        }else{
            coinService.deleteByExternalId(externalCoinId);
            return ResponseEntity.ok().build();
        }
    }
}
