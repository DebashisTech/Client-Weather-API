package com.qsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.responsedto.ResponseStructure;
import com.qsp.service.InternationalWeatherCallService;

@RestController
@RequestMapping("/global")
public class InternationalWeatherController {
	@Autowired
     private InternationalWeatherCallService international;
     
     @GetMapping("/{city}")
     public ResponseEntity<ResponseStructure> getGlobalCity(@PathVariable("city") String city){
    	     return international.getCityWeather(city);
     }
     
     @GetMapping
     public ResponseEntity<ResponseStructure> getAllCity(){
	     return international.getAllCityWeather();
     }
     
     
}
