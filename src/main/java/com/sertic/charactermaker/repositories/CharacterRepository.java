package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.Character;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {

    Character findByExternalCharacterId(UUID externalCharacterId);

    @Query("SELECT c FROM Character c WHERE c.user.externalUserId = ?1")
    List<Character> getAllByExternalUserId(UUID externalUserId);

    @Query("SELECT c FROM Character c WHERE c.user.externalUserId = ?1 and " +
            "c.externalCharacterId = ?2")
    Character getByExternalUserAndCharacterId(UUID externalUserId, UUID externalCharacterId);

    @Modifying
    @Query("DELETE FROM Character c WHERE c.externalCharacterId = ?1")
    void deleteByExternalCharacterId(UUID externalCharacterId);

    @Query("SELECT c FROM Character c WHERE c.race.id = ?1")
    List<Character> gettAllCharactersOfARace(Long raceId);
}
