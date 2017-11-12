package com.hotv.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("applicationContext.xml") //导入xml配置项
public class SimpleApplication extends SpringBootServletInitializer{
	
	/**
	 * 如果需要通过打包的方式在web容器中进行部署，则需要继承 SpringBootServletInitializer 覆盖configure(SpringApplicationBuilder)方法
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SimpleApplication.class);
	}

	public static void main(String[] args) {
		//上下二行皆是启动项目 区别为是否打印Banner
		
		//SpringApplication.run(SimpleApplication.class,args);

        //修改Banner的模式为OFF
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SimpleApplication.class);
        builder.bannerMode(Banner.Mode.OFF).run(args);
	}
	
}
