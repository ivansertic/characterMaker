package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    Item getItemByExternalId(UUID externalItemId);

    List<Item> getAllItems(UUID externalCharacterId);

    Item getItemFromUserAndCharacter(UUID externalUserId, UUID externalCharacterId,
                                     UUID externalItemId);

    void update(UUID externalItemId, Item item);

    void deleteByExternalId(UUID externalItemId);

    void create(Item item);
}
