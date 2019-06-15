package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.Coin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoinRepository extends CrudRepository<Coin, Long> {

    @Query("SELECT c FROM Coin c WHERE c.character.externalCharacterId = ?1")
    List<CoinRepository> getCoinByExternalCharacterId(UUID externalCharacterId);

    @Query("SELECT c FROM Coin c WHERE c.character.user.externalUserId = ?1 and " +
            "c.character.externalCharacterId = ?2 and c.externalId = ?3")
    Coin getCoinByExternalUserAndCharacterId(UUID externalUserId, UUID externalCharacterId,
                                             UUID externalCoinId);

    @Modifying
    @Query("DELETE FROM Coin c WHERE c.externalId = ?1")
    void deleteByExternalCoinId(UUID externalCoinId);
}
