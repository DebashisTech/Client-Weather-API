package com.qsp.modelmapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.qsp.responsedto.ResponseStructure;

@Component
public class ResponseEntityMapper {
	
	private final ResponseStructureModelMapper responseStructureModelMapper;
	
	ResponseEntityMapper(ResponseStructureModelMapper responseStructureModelMapper) {
		this.responseStructureModelMapper = responseStructureModelMapper;
	}
    public ResponseEntity<ResponseStructure> getResponeEntity
        (ResponseStructure payload, HttpStatus status){
	return new ResponseEntity<ResponseStructure> (payload, status);
    }
}
