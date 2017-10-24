package com.lvliang.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppController extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppController.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AppController.class,args);

        //修改Banner的模式为OFF
		//SpringApplicationBuilder builder = new SpringApplicationBuilder(AppController.class);
        //builder.bannerMode(Banner.Mode.OFF).run(args);
	}
	
}
