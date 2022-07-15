package com.mlb.mlb_api.repositories;

import com.mlb.mlb_api.repositories.entities.Draft;
import org.springframework.data.repository.CrudRepository;

public interface DraftRepository extends CrudRepository<Draft, Integer> {
}
