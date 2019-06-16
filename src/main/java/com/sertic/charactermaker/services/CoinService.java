package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Coin;

import java.util.List;
import java.util.UUID;

public interface CoinService {

    Coin getCoinByExternalCoinId(UUID externalCoinId);

    List<Coin> getAllCoinsOfACharacter(UUID externalCharacterId);

    Coin getCoinFromUserAndCharacter(UUID externalUserId, UUID externalCharacterId,
                                     UUID externalCoinId);

    void update(UUID externalCoinId, Coin coin);

    void deleteByExternalId(UUID externalCoinId);

    void create(Coin coin);
}
