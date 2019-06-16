package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Item;
import com.sertic.charactermaker.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepo;
    @Override
    public Item getItemByExternalId(UUID externalItemId) {
        return itemRepo.findByExternalItemId(externalItemId);
    }

    @Override
    public List<Item> getAllItems(UUID externalCharacterId) {
        return itemRepo.getByExternalCharacterId(externalCharacterId);
    }

    @Override
    public Item getItemFromUserAndCharacter(UUID externalUserId, UUID externalCharacterId, UUID externalItemId) {
        return itemRepo.getItemByExternalUserAndCharacterId(externalUserId,externalCharacterId,externalItemId);
    }

    @Override
    public void update(UUID externalItemId, Item item) {
        itemRepo.save(item);
    }

    @Override
    public void deleteByExternalId(UUID externalItemId) {
        itemRepo.deleteByExternalWeaponId(externalItemId);
    }

    @Override
    public void create(Item item) {
        itemRepo.save(item);
    }
}
