package com.hotv.springboot.core.security;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.jagregory.shiro.freemarker.ShiroTags;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

/**
 * 配置freemarker+shiro标签
 * @author hotv
 * @since 2017-11-12
 */
public class PlatformFreeMarkerConfigurer extends FreeMarkerConfigurer {
	Logger logger = Logger.getLogger(PlatformFreeMarkerConfigurer.class);
	
	@Override
	public void afterPropertiesSet() throws IOException, TemplateException {
		//logger.debug("freemarker模板中添加shiro标签");
		System.err.println("----------------freemarker模板中添加shiro标签----------------");
		super.afterPropertiesSet();
		Configuration cfg = this.getConfiguration();
		cfg.setSharedVariable("shiro", new ShiroTags());
	}
	
}
