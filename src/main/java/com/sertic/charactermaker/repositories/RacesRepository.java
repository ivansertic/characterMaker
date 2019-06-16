package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.Race;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacesRepository extends CrudRepository<Race, Long> {

    List<Race> findAll();

    @Query("SELECT r FROM Race r WHERE r.id = ?1")
    Race findByRaceId(Long raceId);
}
