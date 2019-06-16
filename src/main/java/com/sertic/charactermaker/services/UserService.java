package com.sertic.charactermaker.services;

import com.sertic.charactermaker.model.Users;

import java.util.UUID;

public interface UserService {

    Users getUserBYExternalId(UUID externalUserId);

    Users getUserByUsernamAndPassword(String username, String password);

    void createUser(Users user);
}
