package com.donggenun.springJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringJpaApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
