package com.panicbuyinglk.springmvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.panicbuyinglk.springmvc")
@EnableJpaRepositories("com.panicbuyinglk.springmvc.repository")
@EntityScan("com.panicbuyinglk.springmvc.entity")
@PropertySource(value = {"classpath:application.properties","classpath:log4j2.properties"})
public class PanicbuyinglkApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PanicbuyinglkApplication.class, args);

		String loggingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

		System.out.println(loggingTime);
	}

}
