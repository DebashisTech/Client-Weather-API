package com.qsp.serviceImplement;


import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qsp.entity.WeatherReport;
import com.qsp.modelmapper.WeatherMapper;
import com.qsp.repository.WeatherRepository;
import com.qsp.requestdto.WeatherReportUpdateRequestDto;
import com.qsp.requestdto.WeatherSaveDto;
import com.qsp.service.WeatherService;
import com.qsp.util.CacheUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class WeatherServiceImplement implements WeatherService{
	
	@Autowired
    private  final WeatherRepository weatherrepo;
	
	private final WeatherMapper weathermapper;
	private final CacheUtil cacheUtil;

//	@Override
//	@Transactional
//	public String saveCityWeatherInfoService(WeatherReport report)  {
//		
//		WeatherReport weather = weatherrepo.save(report);
//		return "weather report save with id :" +weather.getId();
//	}
	
	@Override
	@Transactional
	public String saveCityWeatherInfoService(WeatherSaveDto dto)  {
		
		WeatherReport report = weathermapper.saveWeatherDtoToWeather(dto, new WeatherReport());
		report=weatherrepo.save(report);
		return dto.toString()+" report saved with id :"+ report.getId();
	}
	@Override
	@Cacheable(value= "fetch", key = "#id")
	public WeatherSaveDto getWeatherByIdService(Integer id) {
	    	Optional<WeatherReport> report = weatherrepo.findById(id);
	    	if(report.isEmpty()) 
	    	{
//	    		return "the given id not present";
//	    	
//	    	String response = " Temperature: "+ report.get().getTemperature()+
//	    			" Summary : "+report.get().getWeathertype();
	    		throw new NoSuchElementException("Data not found with id" + id);
	    	}
//	    	return weathermapper.saveWeatherDtoToWeather(report.get(),new WeatherSaveDto());
	    	return weathermapper.weatherToWeatherSaveDto(report.get(),new WeatherSaveDto());
	    	
	    	
    }
	@Override
	public List<WeatherReport> getAllIndiaWeatherService(){
		return weatherrepo.findAll();
	}
//    @Override
//	public Map<String, String> doUpdateWeatherReport(Integer id, WeatherReportUpdateRequestDto reqdto) {
//		Optional<WeatherReport> report = weatherrepo.findById(id);
//		if(report.isEmpty()) {
//			return null;
//		}
//		WeatherReport reportObject = report.get();
//		String olddata = "Temperature :"+reportObject.getTemperature()+
//				" Description :"+reportObject.getWeathertype();
//		
//		String newdata = "Temperature :"+ reqdto.getTemperature()+
//				" Description :"+reqdto.getDescription();
//		
//		reportObject.setTemperature(reqdto.getTemperature());
//		reportObject.setWeathertype(reqdto.getDescription());
//		weatherrepo.save(reportObject);
//		return Map.of("olddata",olddata,"newdata",newdata);
//		
//	}
	
	 @Override
	 public Map<String, WeatherSaveDto> doUpdateWeatherReport(Integer id, WeatherReportUpdateRequestDto reqdto) {
			Optional<WeatherReport> report = weatherrepo.findById(id);
			if(report.isEmpty()) {
				throw new NoSuchElementException("Data not found with id "+id);
			}
			WeatherReport reportObject = report.get();
			WeatherSaveDto olddata = weathermapper.weatherToWeatherSaveDto(reportObject,new WeatherSaveDto());
			
			WeatherSaveDto newdata = new WeatherSaveDto(reportObject.getCity(),
					                          reqdto.getTemperature(),reqdto.getDescription());
			
			reportObject.setTemperature(reqdto.getTemperature());
			reportObject.setWeathertype(reqdto.getDescription());
			weatherrepo.save(reportObject);
			cacheUtil.updateCacheWhileUpdateWeather(id,newdata);
			return Map.of("olddata",olddata,"newdata",newdata);
			
	 }
	 
	 
     @Override
     @Transactional
     @CacheEvict(value= "fetch", key = "#id")
     
	 public String daleteWeatherService( Integer id) {
		 if(!weatherrepo.existsById(id)) return "data not found with  id"+ id;
		 weatherrepo.deleteById(id);
		 return "Mention data deleteted from database";
	 }
     
     public List<WeatherReport> getWeatherPageService(Integer pagenumber, Integer pagesize){
    	    Pageable pageable=PageRequest.of(pagenumber, pagesize);
    	    return weatherrepo.findAll(pageable).getContent();
     }
	
}
