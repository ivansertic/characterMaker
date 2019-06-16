package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Weapon;

import java.util.List;
import java.util.UUID;

public interface WeaponService {

    Weapon getWeaponByExternalId(UUID externalWeaponId);

    List<Weapon> getAllWeapons(UUID externalCharacterId);

    Weapon getWeaponFromUserAndCharacter(UUID externalUserId, UUID externalCharacterId,
                                         UUID externalWeaponId);

    void update(UUID externalWeaponId, Weapon weapon);

    void deleteByExternalId(UUID externalWeaponId);

    void create(Weapon weapon);
}
