package com.example.RedisCasching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisCaschingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCaschingApplication.class, args);
	}

}
