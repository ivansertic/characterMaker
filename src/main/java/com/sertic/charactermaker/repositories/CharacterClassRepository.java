package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.CharacterClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterClassRepository extends CrudRepository<CharacterClass, Long> {

    List<CharacterClass> findAll();

    @Query("SELECT c FROM CharacterClass c WHERE c.id = ?1")
    CharacterClass findByCharacterClassId(Long characterClassId);
}
