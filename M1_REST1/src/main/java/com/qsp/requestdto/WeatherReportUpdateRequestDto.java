package com.qsp.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor

public class WeatherReportUpdateRequestDto {
   private Integer temperature;
   private String description;
}
