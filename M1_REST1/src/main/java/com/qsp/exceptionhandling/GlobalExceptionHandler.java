package com.qsp.exceptionhandling;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.modelmapper.ResponseEntityMapper;
import com.qsp.modelmapper.ResponseStructureModelMapper;
import com.qsp.responsedto.ResponseStructure;

@RestControllerAdvice

public class GlobalExceptionHandler {
	
	@Autowired
	private ResponseStructureModelMapper responseStructureMapper;
	
	@Autowired
	private ResponseEntityMapper responseEntityMapper;
	
	@ExceptionHandler(NoSuchElementException.class)
	
    public ResponseEntity<ResponseStructure> handleNoSuchElementException(NoSuchElementException ex){
		ResponseStructure structure = responseStructureMapper.mapToResponseStructure(
				HttpStatus.NOT_FOUND,
				"String",
				ex.getMessage()
		);
		structure.setStatus(false);
		return responseEntityMapper.getResponeEntity(structure, HttpStatus.NOT_FOUND);
		
		
    }
	
    @ExceptionHandler(AddClientException.class)
	
    public ResponseEntity<ResponseStructure> handleAddClientException(AddClientException ex){
		ResponseStructure structure = responseStructureMapper.mapToResponseStructure(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"String",
				ex.getMessage()
		);
		structure.setStatus(false);
		return responseEntityMapper.getResponeEntity(structure, HttpStatus.INTERNAL_SERVER_ERROR);
		
		
    }
	
}
