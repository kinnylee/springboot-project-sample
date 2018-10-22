package com.kinnylee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lijl-c
 */
@SpringBootApplication
@ComponentScan("com.kinnylee")
public class SpringbootProjectWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectWebApplication.class, args);
	}
}
