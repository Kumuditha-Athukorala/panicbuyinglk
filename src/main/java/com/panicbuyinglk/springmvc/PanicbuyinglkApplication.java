package com.panicbuyinglk.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.panicbuyinglk.springmvc")
@EnableJpaRepositories("com.panicbuyinglk.springmvc.repository")
@EntityScan("com.panicbuyinglk.springmvc.entity")
@PropertySource(value = {"classpath:application.properties","classpath:log4j2.properties"})
public class PanicbuyinglkApplication {


	public static void main(String[] args) {
		SpringApplication.run(PanicbuyinglkApplication.class, args);
	}

	
}
