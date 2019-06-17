package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
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



    @ManyToOne( cascade = CascadeType.ALL)
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equals(id, weapon.id) &&
                Objects.equals(externalWeaponId, weapon.externalWeaponId) &&
                Objects.equals(name, weapon.name) &&
                Objects.equals(attackBonus, weapon.attackBonus) &&
                Objects.equals(damageType, weapon.damageType) &&
                Objects.equals(character, weapon.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalWeaponId, name, attackBonus, damageType, character);
    }
}
