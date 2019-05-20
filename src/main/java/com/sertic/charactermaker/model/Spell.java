package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy ="org.hibernate.id.UUIDGenerator")
    private UUID externalSpellId;

    private String name;

    private String description;

    private Boolean prepare;

    private String type;

    private Long spellLevel;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @ManyToOne
    private Character character = new Character();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalSpellId() {
        return externalSpellId;
    }

    public void setExternalSpellId(UUID externalSpellId) {
        this.externalSpellId = externalSpellId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPrepare() {
        return prepare;
    }

    public void setPrepare(Boolean prepare) {
        this.prepare = prepare;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(Long spellLevel) {
        this.spellLevel = spellLevel;
    }
}
