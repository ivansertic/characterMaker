package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalItemId;

    private String name;

    private Long amount;

    @ManyToOne
    private Character character = new Character();

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public UUID getExternalItemId() {
        return externalItemId;
    }

    public void setExternalItemId(UUID externalItemId) {
        this.externalItemId = externalItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(Id, item.Id) &&
                Objects.equals(externalItemId, item.externalItemId) &&
                Objects.equals(name, item.name) &&
                Objects.equals(amount, item.amount) &&
                Objects.equals(character, item.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, externalItemId, name, amount, character);
    }
}
