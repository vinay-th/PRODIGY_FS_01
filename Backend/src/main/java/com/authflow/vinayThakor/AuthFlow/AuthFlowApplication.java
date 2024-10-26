package com.authflow.vinayThakor.AuthFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.authflow.vinayThakor.AuthFlow.model")
@EnableJpaRepositories("com.authflow.vinayThakor.AuthFlow.repositories")
public class AuthFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthFlowApplication.class, args);
	}
}
