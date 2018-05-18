package com.exp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
//@MapperScan("com.ecm.dao")
public class ExpressApplication extends SpringBootServletInitializer {

	

//	public static void main(String[] args) {
//		SpringApplication.run(EcNetApplication.class, args);
//	}



}
