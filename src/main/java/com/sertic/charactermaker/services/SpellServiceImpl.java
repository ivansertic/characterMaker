package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Spell;
import com.sertic.charactermaker.repositories.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SpellServiceImpl implements SpellService {

    @Autowired
    private SpellRepository spellRepo;

    @Override
    public Spell getSpellByExternalId(UUID externalSpellId) {
        return spellRepo.findByExternalSpellId(externalSpellId);
    }

    @Override
    public List<Spell> getAllSpells(UUID externalCharacterId) {
        return spellRepo.getByExternalCharacterId(externalCharacterId);
    }

    @Override
    public Spell getSpellFromUserAndCharacter(UUID externalUserId, UUID externalCharacterId, UUID externalSpellId) {
        return spellRepo.getSpellByUserAndCharacterId(externalUserId,externalCharacterId,externalSpellId);
    }

    @Override
    public void update(UUID externalSpellId, Spell spell) {
        spellRepo.save(spell);
    }

    @Override
    public void deleteByExternalSpellId(UUID externalSpellId) {
        spellRepo.deleteByExternalSpellId(externalSpellId);
    }

    @Override
    public void create(Spell spell) {
        spellRepo.save(spell);
    }
}
