package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Coin;
import com.sertic.charactermaker.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CoinServiceImpl implements CoinService{

    @Autowired
    private CoinRepository coinRepo;

    @Override
    public Coin getCoinByExternalCoinId(UUID externalCoinId) {
        return coinRepo.findByExternalId(externalCoinId);
    }

    @Override
    public List<Coin> getAllCoinsOfACharacter(UUID externalCharacterId) {
        return coinRepo.getCoinByExternalCharacterId(externalCharacterId);
    }

    @Override
    public Coin getCoinFromUserAndCharacter(UUID externalUserId, UUID externalCharacterId, UUID externalCoinId) {
        return coinRepo.getCoinByExternalUserAndCharacterId(externalUserId,externalCharacterId,externalCoinId);
    }

    @Override
    public void update(UUID externalCoinId, Coin coin) {
        coinRepo.save(coin);
    }

    @Override
    public void deleteByExternalId(UUID externalCoinId) {
        coinRepo.deleteByExternalCoinId(externalCoinId);
    }

    @Override
    public void create(Coin coin) {
        coinRepo.save(coin);
    }
}
