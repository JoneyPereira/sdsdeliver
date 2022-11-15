package com.redua.dsdeliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DsdeliverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsdeliverApplication.class, args);
	}

}
