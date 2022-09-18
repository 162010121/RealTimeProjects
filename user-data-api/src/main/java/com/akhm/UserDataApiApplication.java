package com.akhm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class UserDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDataApiApplication.class, args);
	}

}
