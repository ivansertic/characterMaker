package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RacesRepository extends CrudRepository<Race, Long> {

    List<Race> findAll();

    Optional<Race> findById(Long raceId);
}