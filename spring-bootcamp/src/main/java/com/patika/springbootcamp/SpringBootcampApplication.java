package com.patika.springbootcamp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "Second Hand API", version = "1.0.0.0", description = "Second Hand Application"))
public class SpringBootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootcampApplication.class, args);
	}

}
