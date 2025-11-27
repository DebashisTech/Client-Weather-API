package com.qsp.modelmapper;

import org.springframework.stereotype.Component;

import com.qsp.entity.WeatherReport;
import com.qsp.requestdto.WeatherSaveDto;

@Component
public class WeatherMapper {
    public WeatherReport saveWeatherDtoToWeather(WeatherSaveDto dto, WeatherReport report) {
    	report.setCity(dto.getCity());
    	report.setTemperature(dto.getTemperature());
    	report.setWeathertype(dto.getWeathertype());
    	return report;
    }
    
    // Entity → DTO (add this method)
    public WeatherSaveDto weatherToWeatherSaveDto(WeatherReport report, WeatherSaveDto dto) {
        dto.setCity(report.getCity());
        dto.setTemperature(report.getTemperature());
        dto.setWeathertype(report.getWeathertype());
        return dto;
    }
}
