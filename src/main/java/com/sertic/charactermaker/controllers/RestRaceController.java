package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.RaceDto;
import com.sertic.charactermaker.mapper.RaceMapper;
import com.sertic.charactermaker.model.Race;
import com.sertic.charactermaker.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/race")
public class RestRaceController {

    @Autowired
    private RaceService raceService;

    @Autowired
    private RaceMapper raceMapper;

    //Return All Races
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<RaceDto>> getAllRaces(){

        final List<Race> races = new LinkedList<>();

        races.addAll(raceService.getAllRaces());

        final List<RaceDto> response = races.stream().map(race -> raceMapper.toDto(race)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    //Return one race
    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public ResponseEntity<RaceDto> getACard(){
        final Race race = raceService.getRaceById(2L);

        return ResponseEntity.ok().body(raceMapper.toDto(race));
    }
}
