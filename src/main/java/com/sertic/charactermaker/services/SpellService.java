package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Spell;

import java.util.List;
import java.util.UUID;

public interface SpellService {

    Spell getSpellByExternalId(UUID externalSpellId);

    List<Spell> getAllSpells(UUID externalCharacterId);

    Spell getSpellFromUserAndCharacter(UUID externalUserId, UUID externalCharacterId,
                                       UUID externalSpellId);

    void update(UUID externalSpellId, Spell spell);

    void deleteByExternalSpellId(UUID externalSpellId);

    void create(Spell spell);
}
