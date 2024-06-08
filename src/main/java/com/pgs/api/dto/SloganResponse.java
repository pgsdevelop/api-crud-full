package com.pgs.api.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SloganResponse {
	private UUID id;
	private UUID userId;
	private String slogan;
}
