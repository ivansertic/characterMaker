package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalSkillId;

    private String name;

    private Long skillPoints;

    @ManyToOne
    private Character character = new Character();

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalSkillId() {
        return externalSkillId;
    }

    public void setExternalSkillId(UUID externalSkillId) {
        this.externalSkillId = externalSkillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(Long skillPoints) {
        this.skillPoints = skillPoints;
    }
}
