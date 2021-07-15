package com.vehicle.regisration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class RegoApplication {

	@Bean
	public AuditorAware<String> auditorAware(){
		//todo get the loggin detail i.e. token or user
		return () -> Optional.of("testUser");
	}

	public static void main(String[] args) {
		SpringApplication.run(RegoApplication.class, args);
	}

}
