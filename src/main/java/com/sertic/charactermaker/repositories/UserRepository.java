package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByExternalUserId(UUID externalUserId);

    Users findByUsernameAndPassword(String username, String password);
}
