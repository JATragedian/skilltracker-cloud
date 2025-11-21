package com.spb.skilltracker.cloud.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SkillServiceApplication {

	static void main(String[] args) {
		SpringApplication.run(SkillServiceApplication.class, args);
	}

}
