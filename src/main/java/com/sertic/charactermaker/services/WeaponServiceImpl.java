package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Weapon;
import com.sertic.charactermaker.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WeaponServiceImpl implements WeaponService {

    @Autowired
    private WeaponRepository weaponRepo;

    @Override
    public Weapon getWeaponByExternalId(UUID externalWeaponId) {
        return weaponRepo.findByExternalWeaponId(externalWeaponId);
    }

    @Override
    public List<Weapon> getAllWeapons(UUID externalCharacterId) {
        return weaponRepo.getWeaponByExternalCharacterId(externalCharacterId);
    }

    @Override
    public Weapon getWeaponFromUserAndCharacter(UUID externalUserId, UUID externalCharacterId, UUID externalWeaponId) {
        return weaponRepo.getWeaponByCharaterAndUser(externalUserId,externalCharacterId,externalWeaponId);
    }

    @Override
    public void update(UUID externalWeaponId, Weapon weapon) {
        weaponRepo.save(weapon);
    }

    @Override
    public void deleteByExternalId(UUID externalWeaponId) {
        weaponRepo.deleteByExternalWeaponId(externalWeaponId);
    }

    @Override
    public void create(Weapon weapon) {
        weaponRepo.save(weapon);
    }

}
