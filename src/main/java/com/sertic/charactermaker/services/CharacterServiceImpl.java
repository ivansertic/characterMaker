package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Character;
import com.sertic.charactermaker.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    private CharacterRepository characterRepo;

    @Override
    public Character getCharacterByExternalId(UUID externalCharacterId) {
        return characterRepo.findByExternalCharacterId(externalCharacterId);
    }

    @Override
    public List<Character> getAllCharactersFromAUser(UUID externalUserId) {
        return characterRepo.getAllByExternalUserId(externalUserId);
    }

    @Override
    public Character GetCharacterFromUser(UUID externalCharacterId, UUID externalUserId) {
        return characterRepo.getByExternalUserAndCharacterId(externalUserId,externalCharacterId);
    }

    @Override
    public void updateCharacter(UUID externalUserId, Character character) {
        characterRepo.save(character);
    }

    @Override
    public void deleteByExternalId(UUID externalCharacterId) {
        characterRepo.deleteByExternalCharacterId(externalCharacterId);
    }

    @Override
    public void createCharacter(Character character) {
        characterRepo.save(character);
    }

    @Override
    public List<Character> getCharacterOfARace(Long id) {
        return characterRepo.gettAllCharactersOfARace(id);
    }
}
