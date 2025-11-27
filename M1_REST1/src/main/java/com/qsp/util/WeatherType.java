package com.qsp.util;

public enum WeatherType {
	COLD,HOT,SUNNY,SMOG,CLOUDY,RAINY,STORM,WINDY;
    public static String getWeatherType(int ordinal)
    {
    	   switch(ordinal) {
    	   case 0:
    		   return COLD.name().toLowerCase();
    	   case 1:
    		   return HOT.name().toLowerCase();
    	   case 2:
    		   return SUNNY.name().toLowerCase();
    	   case 3:
    		   return SMOG.name().toLowerCase();
    	   case 4:
    		   return CLOUDY.name().toLowerCase();
    	   case 5:
    		   return RAINY.name().toLowerCase();
    	   case 6:
    		   return STORM.name().toLowerCase();
    	   default :
    		   return WINDY.name().toLowerCase();
    	   }
    }
}
