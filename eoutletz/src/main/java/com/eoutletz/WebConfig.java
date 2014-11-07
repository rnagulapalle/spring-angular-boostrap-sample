package com.eoutletz;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter {
	
    @Bean
    public MessageSource messageSource() {
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        return messageSource;
    }
    
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
    
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("1280KB");
        factory.setMaxRequestSize("1280KB");
        return factory.createMultipartConfig();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
    	resourceHandlerRegistry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/").setCachePeriod(31556926);
    	resourceHandlerRegistry.addResourceHandler("/styles/**").addResourceLocations("/styles/").setCachePeriod(31556926);
    	resourceHandlerRegistry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(31556926);
    	
    	// Include static content from web jars
    	resourceHandlerRegistry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
    }
}
