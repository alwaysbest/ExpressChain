package com.exp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.ecm.bean")
public class ExpressApplication extends SpringBootServletInitializer {

	

	public static void main(String[] args) {
		SpringApplication.run(ExpressApplication.class, args);
	}



}
