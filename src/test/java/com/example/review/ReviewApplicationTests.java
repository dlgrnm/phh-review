package com.example.review;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class ReviewApplicationTests {

	@Container
	static MySQLContainer mySQLContainer = new MySQLContainer(DockerImageName.parse("mysql:8.0.26"));

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.datasource.url", mySQLContainer.getJdbcUrl());
		dynamicPropertyRegistry.add("spring.datasource.username", mySQLContainer.getUsername());
		dynamicPropertyRegistry.add("spring.datasource.password", mySQLContainer.getPassword());
	}

	@Test
	void contextLoads() {
	}

}
