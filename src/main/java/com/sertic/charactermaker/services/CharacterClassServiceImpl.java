package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.CharacterClass;
import com.sertic.charactermaker.repositories.CharacterClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CharacterClassServiceImpl implements CharacterClassService{

    @Autowired
    private CharacterClassRepository charClassRepo;

    @Override
    public List<CharacterClass> getAllCharacterClasses() {
        return charClassRepo.findAll();
    }

    @Override
    public CharacterClass getCharacterClassById(Long Id) {
        return charClassRepo.findByCharacterClassId(Id);
    }
}
