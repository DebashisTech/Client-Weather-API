package com.qsp.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LibraryBeanCreationConfiguration {
	@Bean("random")
    public  Random createRandomObject() {
    	   return new Random();
    }
	
	@Bean("resttemplate")
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean("otpholder")
	public Map<String, Object[]> createOtpHolder(){
		return new HashMap<String, Object[]>();
	}
}
