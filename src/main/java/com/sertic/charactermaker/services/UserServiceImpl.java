package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Users;
import com.sertic.charactermaker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public Users getUserBYExternalId(UUID externalUserId) {
        return userRepo.findByExternalUserId(externalUserId);
    }

    @Override
    public Users getUserByUsernamAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username,password);
    }

    @Override
    public void createUser(Users user) {
        userRepo.save(user);
    }
}
