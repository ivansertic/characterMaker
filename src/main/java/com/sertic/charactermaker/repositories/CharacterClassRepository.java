package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.CharacterClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterClassRepository extends CrudRepository<CharacterClass, Long> {

    List<CharacterClass> findAll();

    Optional<CharacterClass> findById(Long characterClassId);
}
