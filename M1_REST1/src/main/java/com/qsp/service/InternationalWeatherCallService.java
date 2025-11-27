package com.qsp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.responsedto.ResponseStructure;

@Service
public interface InternationalWeatherCallService {
    ResponseEntity<ResponseStructure> getCityWeather(String city);
    ResponseEntity<ResponseStructure> getAllCityWeather();
}
