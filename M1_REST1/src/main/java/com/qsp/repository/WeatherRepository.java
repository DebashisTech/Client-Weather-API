package com.qsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qsp.entity.WeatherReport;


@Repository
public interface WeatherRepository extends JpaRepository<WeatherReport, Integer>{
//    @Query(value = "select max(id) from weather_report", nativeQuery = true)
//    Integer findMaxId();
}
