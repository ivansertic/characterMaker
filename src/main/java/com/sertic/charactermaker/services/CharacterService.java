package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Character;

import java.util.List;
import java.util.UUID;

public interface CharacterService {

    Character getCharacterByExternalId(UUID externalCharacterId);

    List<Character> getAllCharactersFromAUser(UUID externalUserId);

    Character GetCharacterFromUser(UUID externalCharacterId, UUID externalUserId);

    void updateCharacter(UUID externalCharacterId, Character character);

    void deleteByExternalId(UUID externalCharacterId);

    void createCharacter(Character character);

    List<Character> getCharacterOfARace(Long id);
}
