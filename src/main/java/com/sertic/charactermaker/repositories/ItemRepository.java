package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    Item findByExternalItemId(UUID externalItemId);

    @Query("SELECT i FROM Item i WHERE i.character.externalCharacterId = ?1")
    List<Item> getByExternalCharacterId(UUID externalCharacterId);

    @Query("SELECT i FROM Item i WHERE i.character.user.externalUserId = ?1 and " +
            "i.character.externalCharacterId = ?2 and i.externalItemId = ?3")
    Item getItemByExternalUserAndCharacterId(UUID externalUserId, UUID externalCharacterId,
                                             UUID externalItemId);

    @Modifying
    @Query("DELETE FROM Item i WHERE i.externalItemId = ?1")
    void deleteByExternalWeaponId(UUID externalWeaponId);
}
