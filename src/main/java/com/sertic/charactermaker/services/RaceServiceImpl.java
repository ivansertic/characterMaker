package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Race;
import com.sertic.charactermaker.repositories.RacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RaceServiceImpl implements RaceService {

    @Autowired
    private RacesRepository raceRepo;
    @Override
    public List<Race> getAllRaces() {
        return raceRepo.findAll();
    }

    @Override
    public Race getRaceById(Long Id) {
        return raceRepo.findByRaceId(Id);
    }
}
