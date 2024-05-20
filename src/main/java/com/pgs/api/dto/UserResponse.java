package com.pgs.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	private Long id;
    private String name;
    private String lastName;
    private String address;
    private String city;
    private String email;
}
