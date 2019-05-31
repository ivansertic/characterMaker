package com.sertic.charactermaker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cointype")
public class CoinType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalCoinTypeId;

    private String name;

    @OneToMany(
            mappedBy = "cointype",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Coin> coins = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public UUID getExternalCoinTypeId() {
        return externalCoinTypeId;
    }

    public void setExternalCoinTypeId(UUID externalCoinTypeId) {
        this.externalCoinTypeId = externalCoinTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Coin> getCoins() {
        return coins;
    }

    public void setCoins(Set<Coin> coins) {
        this.coins = coins;
    }
}
