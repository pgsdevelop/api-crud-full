package com.pgs.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	@NotBlank(message = "name cannot be empty")
	@NotNull(message = "name cannot be null")
    private String name;
    
	@NotBlank(message = "lastName cannot be empty")
    @NotNull(message = "lastName cannot be null")
    private String lastName;
    
	@NotBlank(message = "address cannot be empty")
    @NotNull(message = "address cannot be null")
    private String address;
    
	@NotBlank(message = "city cannot be empty")
    @NotNull(message = "city cannot be null")
    private String city;
    
    @NotNull(message = "email cannot be null")
    @Email(message = "The email is not correct")
    private String email;
}
