# springboot+freemarker+mybatis+logback

# @author hotv
# Eclipse Mars.2
# JDK 1.7
# Maven 3.2.5

#与SimpleApplication相同路径设置文件访问路径
#@Configuration
#@EnableWebMvc
#public class WebMvcConfig extends WebMvcConfigurerAdapter{
#	@Override
#    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
#        configurer.enable();
#    } 

#    @Bean
#    public InternalResourceViewResolver viewResolver() {
#        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
#        resolver.setPrefix("/views/");
#        //resolver.setSuffix(".html");
#        return resolver;
#    }

#    @Bean
#    public MessageSource messageSource() {
#        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
#        messageSource.setBasename("trans");
#        messageSource.setDefaultEncoding("UTF-8");
#        return messageSource;
#    }

#    @Bean
#    public LocaleResolver localeResolver(){
#        SessionLocaleResolver resolver = new SessionLocaleResolver();
#        resolver.setDefaultLocale(new Locale("en"));
#        return resolver;
#    }	
#}
