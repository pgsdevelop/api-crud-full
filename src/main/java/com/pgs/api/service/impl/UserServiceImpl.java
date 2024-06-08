package com.pgs.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pgs.api.dto.UserRequest;
import com.pgs.api.dto.UserResponse;
import com.pgs.api.model.User;
import com.pgs.api.repository.UserRepository;
import com.pgs.api.service.UserService;
import com.pgs.api.util.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;

	@Override
	public ResponseEntity<UserResponse> saveUser(UserRequest userRequest) {
		User user = userRepository.save(userMapper.toEntity(userRequest));
		return new ResponseEntity<UserResponse>(userMapper.toResponse(user), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<UserResponse> updateUser(UUID id, UserRequest userRequest) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			User user = userMapper.toEntity(userRequest);
			user.setId(id);
			return ResponseEntity.ok().body(userMapper.toResponse(userRepository.save(user)));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<UserResponse> getUserById(UUID id) {
		Optional<User> user = userRepository.findById(id);
		return user.map(value -> new ResponseEntity<>(userMapper.toResponse(value), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@Override
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		List<UserResponse> users = StreamSupport.stream(userRepository.findAll().spliterator(), false)
				.map(entity -> userMapper.toResponse(entity))
				.collect(Collectors.toList());

		return users.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Set<UserResponse>> getAllUsersV1() {
		Set<UserResponse> users = StreamSupport.stream(userRepository.findAll().spliterator(), false)
				.map(entity -> userMapper.toResponse(entity))
				.collect(Collectors.toSet());

		return users.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(users, HttpStatus.OK);
	}

}
