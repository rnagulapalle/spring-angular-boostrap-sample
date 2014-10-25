package com.eoutletz.domain.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eoutletz.domain.User;
import com.eoutletz.repository.UserRepository;

public class BeforeCreateUserValidator implements Validator {

	private UserRepository userRepository;

	public BeforeCreateUserValidator(final UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) 
	{
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg, Errors errors) 
	{
		User user = (User) arg;
		int userCount = userRepository.getUserCountWithEmail(user.getEmail());
	
		if(userCount > 0) 
		{
			errors.rejectValue("email", null, "The username already exists");
		}
	}
}
