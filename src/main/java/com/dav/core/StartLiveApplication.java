package com.dav.core;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@SpringBootApplication
@ComponentScan({"com.dav"})
public class StartLiveApplication  implements CommandLineRunner{

	@Autowired
	private Environment environment;
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StartLiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LogFactory.getLog(getClass()).info(environment.getProperty("spring.enviroment.property"));
		
	}

}
