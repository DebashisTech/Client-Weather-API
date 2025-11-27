package com.qsp.responsedto;

import java.util.Collection;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemoResponseDto {
	int intdata;
	String stringdata;
	Collection<Integer> collectiondata;
	Map<String, String> mapdata;
    
}
