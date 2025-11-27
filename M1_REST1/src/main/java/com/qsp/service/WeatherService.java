package com.qsp.service;

import java.util.List;
import java.util.Map;

import com.qsp.entity.WeatherReport;
import com.qsp.requestdto.WeatherReportUpdateRequestDto;
import com.qsp.requestdto.WeatherSaveDto;

public interface WeatherService {
//   String saveCityWeatherInfoService(WeatherReport report); 
	 String saveCityWeatherInfoService(WeatherSaveDto dto);
	 
	 WeatherSaveDto getWeatherByIdService(Integer id);
//   String getWeatherByIdService(Integer id);
	 
    	 List<WeatherReport> getAllIndiaWeatherService();
    	 
//   Map<String, String> doUpdateWeatherReport(Integer id, WeatherReportUpdateRequestDto reqdto);
    	 Map<String, WeatherSaveDto> doUpdateWeatherReport(Integer id, WeatherReportUpdateRequestDto reqdto);
    	 
    	 
    	 public String daleteWeatherService(Integer id);
    	 List<WeatherReport> getWeatherPageService(Integer pagenumber, Integer pagesize);
}
