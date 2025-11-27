package com.qsp.controller;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.entity.WeatherReport;
import com.qsp.modelmapper.ResponseEntityMapper;
import com.qsp.modelmapper.ResponseStructureModelMapper;
import com.qsp.requestdto.WeatherReportUpdateRequestDto;
import com.qsp.requestdto.WeatherSaveDto;
import com.qsp.responsedto.ResponseStructure;
import com.qsp.service.WeatherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;

@RestController

@RequiredArgsConstructor
@RequestMapping("/weather")
@Tag(name = "/weather", description = "save, update, remove, delete weather")

public class WeatherController {
	
//	@Autowired
    private  final WeatherService weatherservice;
    private final ResponseStructureModelMapper responseStructureMapper;
    private final ResponseEntityMapper responseEntityMapper;
    
    @PostMapping
    @Operation(description = "post method to save a weather as per city")
    public ResponseEntity<ResponseStructure> saveWeatherReportApi(@RequestBody WeatherSaveDto dto) {
        String serviceResponse = weatherservice.saveCityWeatherInfoService(dto);
        ResponseStructure structure = responseStructureMapper
                .mapToResponseStructure(HttpStatus.CREATED, "String", serviceResponse);
        return responseEntityMapper.getResponeEntity(structure, HttpStatus.CREATED);
    }

    
    @GetMapping("/{id}")
    @Operation(summary = "get the temp, type of weather as per given id as "+" path variable")
    public ResponseEntity<ResponseStructure> getWeatherByID(@PathVariable("id") Integer id) {
    	
    	      WeatherSaveDto serviceresponse = weatherservice.getWeatherByIdService(id);
    	      ResponseStructure structure = responseStructureMapper.mapToResponseStructure(HttpStatus.OK, "object", serviceresponse);
    	      return responseEntityMapper.getResponeEntity(structure, HttpStatus.OK);
    }
   
    @GetMapping
    @Operation(summary = "provide all India weather report")
    public List<WeatherReport> getAllWeather(){
    	    return weatherservice.getAllIndiaWeatherService();
    }
    
    
   @PutMapping("/{id}")
   @Operation(summary = "update weather and show old and new weather data together")
   public ResponseEntity<ResponseStructure> updateWeather(@PathVariable("id") Integer id, @RequestBody WeatherReportUpdateRequestDto dto){
	  Map<String ,WeatherSaveDto> serviceresponse = weatherservice.doUpdateWeatherReport(id, dto);
	  ResponseStructure structure = responseStructureMapper.
			  mapToResponseStructure(HttpStatus.OK, "object", serviceresponse);
  	  return responseEntityMapper.getResponeEntity(structure, HttpStatus.OK);
  }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "delete weather data as per given id")
    public String daleteWeather(@PathVariable("id") Integer id) {
    	   return weatherservice.daleteWeatherService(id);
    }
    
    @GetMapping("/page")
    @Operation(summary = "get group of data , default first 50 data")
    public List<WeatherReport> getWeatherPage
    (@RequestParam(name ="pagenumber", required=false,defaultValue="0") Integer pagenumber,
    	 @RequestParam(name = "pagesize", required=false, defaultValue="25") Integer pagesize	){
    	      return weatherservice.getWeatherPageService(pagenumber, pagesize);
    }
    
}
