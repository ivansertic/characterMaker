package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalRaceId;

    private String name;

    @OneToMany(
            mappedBy = "race",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Character> characters = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalRaceId() {
        return externalRaceId;
    }

    public void setExternalRaceId(UUID externalRaceId) {
        this.externalRaceId = externalRaceId;
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

    public void addCharacter(Character character){
        characters.add(character);
        character.setRace(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(id, race.id) &&
                Objects.equals(externalRaceId, race.externalRaceId) &&
                Objects.equals(name, race.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalRaceId, name);
    }
}
