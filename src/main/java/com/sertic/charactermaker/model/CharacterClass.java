package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "characterclass")
public class CharacterClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalCharacterClassId;

    private String name;

    @OneToMany(
            mappedBy = "characterclass",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Character> characters = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalCharacterClassId() {
        return externalCharacterClassId;
    }

    public void setExternalCharacterClassId(UUID externalCharacterClassId) {
        this.externalCharacterClassId = externalCharacterClassId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }
}
