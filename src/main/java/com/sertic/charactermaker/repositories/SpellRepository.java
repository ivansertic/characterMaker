package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.Spell;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpellRepository extends CrudRepository<Spell,Long> {

    Spell findByExternalSpellId(UUID externalSpellId);

    @Query("SELECT s FROM Spell s WHERE s.character.externalCharacterId = ?1")
    List<Spell> getByExternalCharacterId(UUID externalCharacterId);

    @Query("SELECT s FROM Spell s WHERE s.character.user.externalUserId = ?1 and s.character.externalCharacterId = ?2 and s.externalSpellId = ?3")
    Spell getSpellByUserAndCharacterId(UUID externalUserId, UUID externalCharacterId, UUID externalSpellId);

    @Modifying
    @Query("DELETE FROM Spell s WHERE s.externalSpellId = ?1")
    void deleteByExternalSpellId(UUID externalSpellId);
}
