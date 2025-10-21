package com.ws_rr6_safa_calculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WsRr6PlenitApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(WsRr6PlenitApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(WsRr6PlenitApplication.class, args);
	}

}
