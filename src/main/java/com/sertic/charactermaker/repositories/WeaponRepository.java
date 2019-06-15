package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.Weapon;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, Long> {

    @Query("SELECT w FROM Weapon w WHERE w.character.user.externalUserId = ?1 and " +
            "w.character.externalCharacterId = ?2 and w.externalWeaponId = ?3")
    Weapon getWeaponByCharaterAndUser(UUID externalUserId, UUID externalCharacterID, UUID externalWeaponId);


    @Query("SELECT w FROM Weapon  w WHERE w.character.externalCharacterId = ?1")
    List<Weapon> getWeaponByExternalCharacterId(UUID externalCharacterId);

    @Modifying
    @Query("DELETE FROM Weapon w WHERE w.externalWeaponId = ?1")
    void deleteByExternalWeaponId(UUID externalWeaponId);
}
