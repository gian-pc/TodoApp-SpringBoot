package com.gianpc.restapis;

import com.gianpc.restapis.domains.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;

// ComponentScan: controllers, services, repositories para agregar al classpath
// EnableAutoConfiguration: Configura automaticamente el contexto de Spring Boot
// SpringBootConfiguration: Configura el contexto de Spring Boot
// SpringBootApplication: Anotacion que combina las tres anotaciones anteriores

@SpringBootApplication
public class RestapisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapisApplication.class, args);
	}

	@Bean
	public RepresentationModelProcessor<EntityModel<Todo>> todoProcessor(){
		return new RepresentationModelProcessor<EntityModel<Todo>>(){
			@Override
			public EntityModel<Todo> process(EntityModel<Todo> model){
				model.add(Link.of("http://localhost:8080/todoTypes", "types"));
				return model;
			}
		};
	}
}
