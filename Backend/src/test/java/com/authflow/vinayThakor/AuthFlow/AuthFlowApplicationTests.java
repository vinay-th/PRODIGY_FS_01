package com.authflow.vinayThakor.AuthFlow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.authflow.vinayThakor.AuthFlow.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class AuthFlowApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		assertNotNull(userRepository, "UserRepository should not be null");
	}

}
