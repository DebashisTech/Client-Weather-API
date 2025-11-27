package com.qsp.runner;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.qsp.entity.WeatherReport;
import com.qsp.repository.WeatherRepository;
import com.qsp.util.WeatherType;

@Component
public class DataDumpingRunner implements CommandLineRunner {
	@Autowired
	private WeatherRepository weatherrepo;
    
	@Autowired
	private Random random;
	@Override
	public void run(String ...  args) throws Exception {
		Long count = weatherrepo.count();
		count= 150-count;
		if(count<=0) return;
		String dummycity = "DummyCity";
		for(int i=0;i<=count;i++) {
			String tempcity=dummycity+i;
			String weathertype = WeatherType.getWeatherType(random.nextInt(9));
			Integer temperature = random.nextInt(36)+15;
			WeatherReport report = new WeatherReport(tempcity, temperature, weathertype);
			weatherrepo.save(report);
			
		}
		
	}

}
