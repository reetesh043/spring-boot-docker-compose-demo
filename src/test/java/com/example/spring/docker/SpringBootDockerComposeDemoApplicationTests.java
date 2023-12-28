package com.example.spring.docker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
class SpringBootDockerComposeDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
