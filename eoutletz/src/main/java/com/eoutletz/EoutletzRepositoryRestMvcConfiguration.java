package com.eoutletz;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.eoutletz.domain.validator.BeforeCreateUserValidator;
import com.eoutletz.repository.UserRepository;

/**
 * This is used to register custom validators for validating entities. 
 *
 * @author sbelida
 *
 */
@Configuration
public class EoutletzRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration
{
	@Inject 
	private UserRepository userRepository;
	
	@Override
	protected void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) 
	{
		v.addValidator("beforeCreate", new BeforeCreateUserValidator(userRepository));
	}
	
}
