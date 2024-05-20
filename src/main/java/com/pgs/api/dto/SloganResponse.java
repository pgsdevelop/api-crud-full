package com.pgs.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SloganResponse {
	private Long id;
	private Long userId;
	private String slogan;
}
