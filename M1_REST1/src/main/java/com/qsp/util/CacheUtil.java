package com.qsp.util;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import com.qsp.requestdto.WeatherSaveDto;

@Component
public class CacheUtil {
	@CachePut(value="fetch" , key="#id")
	public WeatherSaveDto updateCacheWhileUpdateWeather(Integer id, WeatherSaveDto dto) {
		return dto;
	}
	
	
    
}
