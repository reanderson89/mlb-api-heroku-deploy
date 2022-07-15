package com.mlb.mlb_api.repositories;

import com.mlb.mlb_api.repositories.entities.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    Team findByName(String name);
    Boolean existsByName(String name);
    void deleteByName(String name);
}
