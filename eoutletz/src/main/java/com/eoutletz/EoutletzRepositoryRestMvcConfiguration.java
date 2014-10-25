package com.eoutletz;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.eoutletz.domain.validator.BeforeCreatePartnerValidator;
import com.eoutletz.domain.validator.BeforeCreateUserValidator;
import com.eoutletz.repository.PartnerRepository;
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
	
	@Inject
	private PartnerRepository partnerRepository;
	
	@Override
	protected void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) 
	{
		v.addValidator("beforeCreate", new BeforeCreateUserValidator(userRepository));
		
		v.addValidator("beforeCreate", new BeforeCreatePartnerValidator(partnerRepository));
	}
	
	@Override
	  protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	    super.configureRepositoryRestConfiguration(config);
	    try {
	      config.setBaseUri(new URI("/api"));
	    } catch (URISyntaxException e) {
	      e.printStackTrace();
	    }
	  }
}
