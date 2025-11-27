package com.qsp.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qsp.responsedto.ResponseStructure;
import com.qsp.service.InternationalWeatherCallService;


@Service
public class InternationalWeatherServiceCallImplement implements InternationalWeatherCallService{
	 @Value("${baseurl}")
     private String base_url;
	 
	 @Autowired
	 private RestTemplate resttemplate;
	 
	 @Override
	    public ResponseEntity<ResponseStructure> getCityWeather(String city)
	    {
	        String url = base_url + "/weather/" + city;

	        ResponseEntity<ResponseStructure> entity =
	                resttemplate.exchange(
	                        url,
	                        HttpMethod.GET,
	                        null,
	                        new ParameterizedTypeReference<ResponseStructure>() {}
	                );

	        return entity;
	    }

	    @Override
	    public ResponseEntity<ResponseStructure> getAllCityWeather()
	    {String url=base_url+"/weather";
	    ResponseEntity<ResponseStructure> entity =
                resttemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ResponseStructure>() {}
                );

	    return entity;
	    }
	
	 
     
}
