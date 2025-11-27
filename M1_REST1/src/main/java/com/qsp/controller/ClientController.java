package com.qsp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.modelmapper.ResponseEntityMapper;
import com.qsp.modelmapper.ResponseStructureModelMapper;
import com.qsp.requestdto.ClientSaveDto;
import com.qsp.responsedto.ResponseStructure;
import com.qsp.service.MailOtpService;
import com.qsp.util.ClientType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
@Tag(name="/client", description="API related to clients")
public class ClientController {
	
	private final ResponseStructureModelMapper responseStructureMapper;
	
	private final ResponseEntityMapper responseEntityMapper ;
	
	private final MailOtpService mailservice;
	
	@GetMapping("/registerpre")
	@Operation(description = "return all user type before add new user")
    public ResponseEntity<ResponseStructure> userRegistrationPreprocessing() {
    	   String[] payload = ClientType.getAllTypes();
    	   ResponseStructure structure = responseStructureMapper.mapToResponseStructure(HttpStatus.OK, "array", payload);
    	   return responseEntityMapper.getResponeEntity(structure, HttpStatus.OK);
    	   
    }
	
	@PostMapping
	public String verifyClient(@RequestBody ClientSaveDto dto) {
		return mailservice.sentOtp(dto.getEmail(), dto);
	}
	
	@PostMapping("/{email}/{otp}")
	public String saveClient(@PathVariable("email") String email,
			                 @PathVariable("otp") String otp) {
		return mailservice.validateOtp(email, otp);
	}
}
