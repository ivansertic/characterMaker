package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.CharacterClass;

import java.util.List;

public interface CharacterClassService {

    List<CharacterClass> getAllCharacterClasses();

    CharacterClass getCharacterClassById(Long Id);
}
