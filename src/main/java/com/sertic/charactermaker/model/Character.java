package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalCharacterId;

    private String name;

    private String characterClass;

    private String race;

    //Adding tables and relations for database//

    @OneToMany(
            mappedBy = "character",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Spell> spells = new HashSet<>();


    @OneToMany(
            mappedBy = "character",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Weapon> weapons = new HashSet<>();


    @OneToMany(
            mappedBy = "character",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Item> items = new HashSet<>();

    @OneToMany(
            mappedBy = "character",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Skill> skills = new HashSet<>();

    @OneToMany(
            mappedBy = "character",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Coin> coins = new HashSet<>();

    @OneToOne(
            mappedBy = "character",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private CharacterStatistic characterStatistic;


    //Getters and Setters for Lists//
    public Set<Spell> getSpells() {
        return spells;
    }

    public void setSpells(Set<Spell> spells) {
        this.spells = spells;
    }

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Set<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Coin> getCoins() {
        return coins;
    }

    public void setCoins(Set<Coin> coins) {
        this.coins = coins;
    }

    public CharacterStatistic getCharacterStatistic() {
        return characterStatistic;
    }

    public void setCharacterStatistic(CharacterStatistic characterStatistic) {
        this.characterStatistic = characterStatistic;
    }


    //Logic behind adding and removing things to lists//
    public void addSpell(Spell spell){
        spells.add(spell);
        spell.setCharacter(this);
    }

    public void removeSpell(Spell spell){
        spells.remove(spell);
        spell.setCharacter(null);
    }


    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
        weapon.setCharacter(this);
    }

    public void removeWeapon(Weapon weapon){
        weapons.remove(weapon);
        weapon.setCharacter(null);
    }


    public void addItem(Item item){
        items.add(item);
        item.setCharacter(this);
    }

    public void removeItem(Item item){
        items.remove(item);
        item.setCharacter(null);
    }


    public void addCoin(Coin coin){
        coins.add(coin);
        coin.setCharacter(this);
    }

    public void removeCoin(Coin coin){
        coins.remove(coin);
        coin.setCharacter(null);
    }


    public void addSkill(Skill skill){
        skills.add(skill);
        skill.setCharacter(this);
    }

    public void removeSkill(Skill skill){
        skills.remove(skill);
        skill.setCharacter(this);
    }



    //Getters and Setters for Character class(table)//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalCharacterId() {
        return externalCharacterId;
    }

    public void setExternalCharacterId(UUID externalCharacterId) {
        this.externalCharacterId = externalCharacterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
