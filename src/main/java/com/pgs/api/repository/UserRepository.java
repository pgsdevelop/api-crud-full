package com.pgs.api.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.pgs.api.model.User;

public interface UserRepository extends CrudRepository<User, UUID>{

}
