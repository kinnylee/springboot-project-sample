package com.kinnylee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lijl-c
 */
@SpringBootApplication
@MapperScan("com.kinnylee.dao")
@ComponentScan("com.kinnylee")
public class SpringbootProjectMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectMybatisApplication.class, args);
	}
}
