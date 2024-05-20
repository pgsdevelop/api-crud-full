package com.pgs.api.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pgs.api.dto.UserRequest;
import com.pgs.api.dto.UserResponse;
import com.pgs.api.model.User;

@Component
@RequiredArgsConstructor
public class UserMapper {
	
    private final ModelMapper mapper;
    
    public User toEntity(UserRequest userRequest) {
    	 return mapper.map(userRequest, User.class);
    }
    
    public UserResponse toResponse(User user) {
        return mapper.map(user, UserResponse.class);
    }

}
