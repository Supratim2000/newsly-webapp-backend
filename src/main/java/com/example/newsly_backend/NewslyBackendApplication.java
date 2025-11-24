package com.example.newsly_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NewslyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewslyBackendApplication.class, args);
	}

}
