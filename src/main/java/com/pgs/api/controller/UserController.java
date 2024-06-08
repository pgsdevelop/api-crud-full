package com.pgs.api.controller;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgs.api.dto.SloganRequest;
import com.pgs.api.dto.SloganResponse;
import com.pgs.api.dto.UserRequest;
import com.pgs.api.dto.UserResponse;
import com.pgs.api.service.SloganService;
import com.pgs.api.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	private final SloganService sloganService;
	
	@PostMapping
	public ResponseEntity<UserResponse> signin(@Valid @RequestBody final UserRequest user) {
		try {
			return userService.saveUser(user);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserResponse> updateUser(@PathVariable("id") UUID id, @Valid @RequestBody final UserRequest user) {
		try {
			return userService.updateUser(id, user);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable(value = "id") UUID id){
        return userService.getUserById(id);
    }
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "v1/all")
	public ResponseEntity<Set<UserResponse>> getAllUsersV1() {
		return userService.getAllUsersV1();
	}
	
	@PostMapping(value = "/slogan")
	public ResponseEntity<?> slogan(@Valid @RequestBody final SloganRequest sloganRequest) {
		try {
			return sloganService.saveSlogan(sloganRequest);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/slogan/all")
	public ResponseEntity<List<SloganResponse>> getAllSlogans() {
		return sloganService.getAllSlogans();
	}	
}
