package com.pgs.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pgs.api.dto.SloganRequest;
import com.pgs.api.dto.SloganResponse;
import com.pgs.api.handler.ApiErrorExtended;
import com.pgs.api.handler.ArchErrorCode;
import com.pgs.api.model.Slogan;
import com.pgs.api.repository.SloganRepository;
import com.pgs.api.service.SloganService;
import com.pgs.api.util.SloganMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SloganServiceImpl implements SloganService{

	private final SloganRepository sloganRepository;
	
	private final SloganMapper sloganMapper;
	
	private static final Long maxSlogans = 3L;

	@Override
	public ResponseEntity<?> saveSlogan(SloganRequest sloganRequest) {
		List<Slogan> slogansUser = sloganRepository.findByUserId(sloganRequest.getUserId());
		if(!slogansUser.isEmpty() && slogansUser.size() >= maxSlogans) {
			final ApiErrorExtended apiError = new ApiErrorExtended(ArchErrorCode.TECH_002, ArchErrorCode.TECH_002.getReasonPhrase(), null);
			return ResponseEntity.badRequest().body(apiError);
		}else {
			Slogan slogan = sloganRepository.save(sloganMapper.toEntity(sloganRequest));
			return new ResponseEntity<SloganResponse>(sloganMapper.toResponse(slogan), HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<List<SloganResponse>> getAllSlogans() {
		List<SloganResponse> slogans = StreamSupport.stream(sloganRepository.findAll().spliterator(), false)
				.map(entity -> sloganMapper.toResponse(entity))
				.collect(Collectors.toList());

		return slogans.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(slogans, HttpStatus.OK);
	}
	
	
}
