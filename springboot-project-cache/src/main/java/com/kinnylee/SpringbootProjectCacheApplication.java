package com.kinnylee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootProjectCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectCacheApplication.class, args);
	}
}
