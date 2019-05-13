package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalWeaponId;

    private String name;

    private Long attackBonus;

    private String damageType;

    private Boolean equip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalWeaponId() {
        return externalWeaponId;
    }

    public void setExternalWeaponId(UUID externalWeaponId) {
        this.externalWeaponId = externalWeaponId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(Long attackBonus) {
        this.attackBonus = attackBonus;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public Boolean getEquip() {
        return equip;
    }

    public void setEquip(Boolean equip) {
        this.equip = equip;
    }
}
