package com.hotv.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("applicationContext.xml") //导入xml配置项
public class SimpleApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SimpleApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class,args);

        //修改Banner的模式为OFF
		//SpringApplicationBuilder builder = new SpringApplicationBuilder(AppController.class);
        //builder.bannerMode(Banner.Mode.OFF).run(args);
	}
	
}
