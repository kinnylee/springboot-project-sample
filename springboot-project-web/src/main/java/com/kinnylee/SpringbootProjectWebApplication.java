package com.kinnylee;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kinnylee")
public class SpringbootProjectWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectWebApplication.class, args);
	}
}
