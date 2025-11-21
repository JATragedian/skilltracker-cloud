package com.spb.skilltracker.cloud.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UserServiceApplication {

	static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
