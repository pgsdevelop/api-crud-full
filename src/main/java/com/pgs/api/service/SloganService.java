package com.pgs.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pgs.api.dto.SloganRequest;
import com.pgs.api.dto.SloganResponse;

public interface SloganService {

	ResponseEntity<?> saveSlogan(SloganRequest sloganRequest);

	ResponseEntity<List<SloganResponse>> getAllSlogans();
}
