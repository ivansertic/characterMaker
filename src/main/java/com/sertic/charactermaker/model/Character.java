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

    //Character statistics
    private Long armourClass;

    private Long initiative;

    private Long speed;

    private Long hitPoints;

    private Long characterLevel;

    private Long expiriencePoints;


    // Skills
    private Long strength;

    private Long dexterity;

    private Long constitution;

    private Long intelligence;

    private Long wisdom;

    private Long charisma;

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
    private Set<Coin> coins = new HashSet<>();

    @ManyToOne
    private Users user;

    @ManyToOne
    private Race race;

    @ManyToOne
    private CharacterClass characterclass;




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

    public Set<Coin> getCoins() {
        return coins;
    }

    public void setCoins(Set<Coin> coins) {
        this.coins = coins;
    }



    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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




    /* Character Statistics */
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

    public Long getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Long hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Long getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(Long characterLevel) {
        this.characterLevel = characterLevel;
    }

    public Long getExpiriencePoints() {
        return expiriencePoints;
    }

    public void setExpiriencePoints(Long expiriencePoints) {
        this.expiriencePoints = expiriencePoints;
    }



    /*Getters And Setters For Races And Classes*/

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public CharacterClass getCharacterClass() {
        return characterclass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterclass = characterClass;
    }



    /*Getters and setters for skills*/

    public Long getStrength() {
        return strength;
    }

    public void setStrength(Long strength) {
        this.strength = strength;
    }

    public Long getDexterity() {
        return dexterity;
    }

    public void setDexterity(Long dexterity) {
        this.dexterity = dexterity;
    }

    public Long getConstitution() {
        return constitution;
    }

    public void setConstitution(Long constitution) {
        this.constitution = constitution;
    }

    public Long getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Long intelligence) {
        this.intelligence = intelligence;
    }

    public Long getWisdom() {
        return wisdom;
    }

    public void setWisdom(Long wisdom) {
        this.wisdom = wisdom;
    }

    public Long getCharisma() {
        return charisma;
    }

    public void setCharisma(Long charisma) {
        this.charisma = charisma;
    }
}
