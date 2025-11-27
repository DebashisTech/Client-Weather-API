package com.qsp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class WeatherReportAspect {
	@Before("execution(* com.qsp.ServiceImplement.WeatherServiceImplement.*(..))")
    public void beforeApiCallLog(JoinPoint joinpoint) {
		  log.info("{} - {} method called",
	                joinpoint.getTarget().getClass().getName(),
	                joinpoint.getSignature().getName());
   }
	
	@After("execution(* com.qsp.ServiceImplement.WeatherServiceImplement.*(..))")
    public void afterApiCallLog(JoinPoint joinpoint) {
	    log.info("{} - {} method executed",
                joinpoint.getTarget().getClass().getName(),
                joinpoint.getSignature().getName());
   }
	@AfterReturning("execution(* com.qsp.ServiceImplement.WeatherServiceImplement.*(..))")
	public void afterReturningLog(JoinPoint joinpoint) {
		log.info("After returning from method : " + joinpoint.getSignature().getName());
	}

	@AfterThrowing(pointcut = "execution(* com.qsp.ServiceImplement.WeatherServiceImplement.*(..))",throwing="ex")
	public void afterexception(JoinPoint joinpoint, Throwable ex) {
		  log.error("Exception in {}.{}() with cause = {}", 
	                joinpoint.getTarget().getClass().getName(),
	                joinpoint.getSignature().getName(),
	                ex.getMessage());
	}

	@Around("execution(* com.qsp.ServiceImplement.WeatherServiceImplement.*(..))")
	public Object executionTime(ProceedingJoinPoint point) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = point.proceed();
		long endTime = System.currentTimeMillis();
		log.info("Execution time of " + point.getSignature().getName() + " :: " + (endTime - startTime) + " milli second");
		return result;
	}
	
	
    
}
