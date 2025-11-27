package com.qsp.modelmapper;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.qsp.responsedto.ResponseStructure;

@Component
public class ResponseStructureModelMapper {
    public ResponseStructure mapToResponseStructure(HttpStatus httpstatus,String type, Object payload) {
    	ResponseStructure structure = ResponseStructure.builder()
    			.status(true)
    			.payload(payload)
    			.statuscode(httpstatus.value())
    			.type(type).build();
    	return structure;
    }
}
