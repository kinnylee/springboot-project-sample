package com.kinnylee;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijl-c
 */
@SpringBootApplication
@EnableAdminServer
public class SpringbootProjectAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectAdminServerApplication.class, args);
	}
}
