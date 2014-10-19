package com.eoutletz;

import javax.inject.Inject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.eoutletz.domain.handler.UserEventHandler;
import com.eoutletz.repository.UserRepository;

@Configuration
@ComponentScan
@Import( {EoutletzRepositoryRestMvcConfiguration.class, SecurityConfig.class} )
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
    
}