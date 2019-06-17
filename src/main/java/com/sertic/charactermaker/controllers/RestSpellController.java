package com.sertic.charactermaker.controllers;

import com.sertic.charactermaker.mapper.SpellMapper;
import com.sertic.charactermaker.services.CharacterService;
import com.sertic.charactermaker.services.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RestSpellController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private SpellService spellService;

    @Autowired
    private SpellMapper spellMapper;


    //Create Spell
}
