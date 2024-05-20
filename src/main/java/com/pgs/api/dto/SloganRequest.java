package com.pgs.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SloganRequest {
	
    @NotNull(message = "userId cannot be null")
	private Long userId;
    
    @NotNull(message = "slogan cannot be null")
    @Size(min = 1, max = 255, message = "slogan length must be between 1 and 255 characters")
	private String slogan;

}
