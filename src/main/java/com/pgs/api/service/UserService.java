package com.pgs.api.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.pgs.api.dto.UserRequest;
import com.pgs.api.dto.UserResponse;

public interface UserService {

	ResponseEntity<UserResponse> saveUser(UserRequest user);
	
	ResponseEntity<UserResponse> updateUser(UUID id, UserRequest user);
	
	ResponseEntity<UserResponse> getUserById(UUID id);

	ResponseEntity<List<UserResponse>> getAllUsers();

	ResponseEntity<Set<UserResponse>> getAllUsersV1();
}
