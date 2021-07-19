package com.douglas.ctrlcorredor_v9_JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.douglas" })
@EntityScan(basePackages = { "com.douglas" })

@EnableJpaRepositories(basePackages = {"com.douglas"})

public class CtrlcorredorV7Application {

	public static void main(String[] args) {
		SpringApplication.run(CtrlcorredorV7Application.class, args);
	}

}
