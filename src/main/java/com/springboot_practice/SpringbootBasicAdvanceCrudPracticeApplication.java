package com.springboot_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootBasicAdvanceCrudPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBasicAdvanceCrudPracticeApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		// Replace with logic to get current user from Spring Security if needed
		return () -> Optional.of("system");
	}
}











//package com.springboot_practice;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//
//import java.util.Optional;
//
//@SpringBootApplication
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
//public class SpringbootBasicAdvanceCrudPracticeApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringbootBasicAdvanceCrudPracticeApplication.class, args);
//	}
//
//	@Bean
//	public AuditorAware<String> auditorProvider() {
//		// Replace with logic to get current user from Spring Security if needed
//		return () -> Optional.of("system");
//	}
//}
