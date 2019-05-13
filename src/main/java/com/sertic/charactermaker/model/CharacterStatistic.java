package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CharacterStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy ="org.hibernate.id.UUIDGenerator")
    private UUID externalChStatisticId;

    private Long armourClass;

    private Long initiative;

    private Long speed;

    private Long hitPoints;

    private Long characterLevel;

    private Long expiriencePints;

    public void setHitPoints(Long hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Long getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(Long characterLevel) {
        this.characterLevel = characterLevel;
    }

    public Long getExpiriencePints() {
        return expiriencePints;
    }

    public void setExpiriencePints(Long expiriencePints) {
        this.expiriencePints = expiriencePints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalChStatisticId() {
        return externalChStatisticId;
    }

    public void setExternalChStatisticId(UUID externalChStatisticId) {
        this.externalChStatisticId = externalChStatisticId;
    }

    public Long getArmourClass() {
        return armourClass;
    }

    public void setArmourClass(Long armourClass) {
        this.armourClass = armourClass;
    }

    public Long getInitiative() {
        return initiative;
    }

    public void setInitiative(Long initiative) {
        this.initiative = initiative;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    public long getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(long hitPoints) {
        this.hitPoints = hitPoints;
    }
}
