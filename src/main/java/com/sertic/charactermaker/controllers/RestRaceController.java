package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.dto.RaceDto;
import com.sertic.charactermaker.mapper.RaceMapper;
import com.sertic.charactermaker.model.Race;
import com.sertic.charactermaker.services.RaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public static final Logger logger = LoggerFactory.getLogger(RestCharacterController.class);


    //Return All Races
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<RaceDto>> getAllRaces(){

        final List<Race> races = new LinkedList<>();

        races.addAll(raceService.getAllRaces());

        final List<RaceDto> response = races.stream().map(race -> raceMapper.toDto(race)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    //Return one race
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RaceDto> getACard(@PathVariable("id")Long id){
        final Race race = raceService.getRaceById(id);

        if(race == null){
            return ResponseEntity.notFound().build();
        }else {

            return ResponseEntity.ok().body(raceMapper.toDto(race));
        }
    }
}
