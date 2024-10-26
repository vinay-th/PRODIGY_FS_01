package com.authflow.vinayThakor.AuthFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import com.authflow.vinayThakor.AuthFlow.repositories.UserRepository;

@SpringBootApplication
public class AuthFlowApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthFlowApplication.class, args);
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run() {
		return args -> {
			System.out.println("Application started successfully!");
			System.out.println("User count: " + userRepository.count());
		};
	}
}
