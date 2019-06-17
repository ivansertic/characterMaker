package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalId;

    private String coinType;

    private Long amount;


    @ManyToOne(cascade = CascadeType.ALL)
    private Character character = new Character();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

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

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Objects.equals(id, coin.id) &&
                Objects.equals(externalId, coin.externalId) &&
                Objects.equals(coinType, coin.coinType) &&
                Objects.equals(amount, coin.amount) &&
                Objects.equals(character, coin.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, coinType, amount, character);
    }
}
