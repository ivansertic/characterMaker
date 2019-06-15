package com.sertic.charactermaker.repositories;

import com.sertic.charactermaker.model.CoinType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoinTypeRepository extends CrudRepository<CoinType, Long> {

    List<CoinType> findAll();

    Optional<CoinType> findById(Long coinTypeId);
}
