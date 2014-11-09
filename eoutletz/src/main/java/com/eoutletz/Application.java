package com.eoutletz;

import javax.inject.Inject;
import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.eoutletz.domain.handler.UserEventHandler;
import com.eoutletz.repository.UserRepository;

@Configuration
@ComponentScan
@Import( {EoutletzRepositoryRestMvcConfiguration.class, SecurityConfig.class, WebConfig.class, MailConfiguration.class} )
@EnableAutoConfiguration
public class Application 
{
	@Inject 
	private UserRepository userRepository;
    
    @Bean 
    public UserEventHandler userEventHandler() 
    {
        return new UserEventHandler(userRepository);
    }
    
    @Bean
    public Filter siteMeshFilterBean() 
    {
	    EOutletzSiteMeshFilter esmf = new EOutletzSiteMeshFilter(); 
	    return esmf;
    }
}