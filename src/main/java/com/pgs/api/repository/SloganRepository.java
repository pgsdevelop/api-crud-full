package com.pgs.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pgs.api.model.Slogan;

public interface SloganRepository extends CrudRepository<Slogan, Long>{

	List<Slogan> findByUserId(Long userId);
}
