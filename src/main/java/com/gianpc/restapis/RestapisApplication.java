package com.gianpc.restapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ComponentScan: controllers, services, repositories para agregar al classpath
// EnableAutoConfiguration: Configura automaticamente el contexto de Spring Boot
// SpringBootConfiguration: Configura el contexto de Spring Boot
// SpringBootApplication: Anotacion que combina las tres anotaciones anteriores

@SpringBootApplication
public class RestapisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapisApplication.class, args);
	}

}
