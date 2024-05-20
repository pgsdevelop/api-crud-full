package com.pgs.api.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pgs.api.dto.SloganRequest;
import com.pgs.api.dto.SloganResponse;
import com.pgs.api.model.Slogan;

@Component
@RequiredArgsConstructor
public class SloganMapper {
	
    private final ModelMapper mapper;
    
    public Slogan toEntity(SloganRequest sloganRequest) {
    	 return mapper.map(sloganRequest, Slogan.class);
    }
    
    public SloganResponse toResponse(Slogan slogan) {
        return mapper.map(slogan, SloganResponse.class);
    }

}
