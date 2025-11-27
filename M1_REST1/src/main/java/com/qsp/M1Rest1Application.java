package com.qsp;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "M1_REST_API",
                          description = "Demo learning project",
                          version = "1.2" ),
                    servers = {
                    		@Server(url = "http://localhost:8080",
                    				description = "local dev server")
                              }
                  )

@EnableAspectJAutoProxy
@EnableCaching
@EnableJpaAuditing
@EnableAsync
public class M1Rest1Application {
    
	public static void main(String[] args) {
		SpringApplication.run(M1Rest1Application.class, args);
	}
}
