package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Race;

import java.util.List;

public interface RaceService {

    List<Race> getAllRaces();

    Race getRaceById(Long Id);
}
