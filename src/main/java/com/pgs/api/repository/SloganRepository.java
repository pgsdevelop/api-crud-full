package com.pgs.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.pgs.api.model.Slogan;

public interface SloganRepository extends CrudRepository<Slogan, UUID>{

	List<Slogan> findByUserId(UUID userId);
}
