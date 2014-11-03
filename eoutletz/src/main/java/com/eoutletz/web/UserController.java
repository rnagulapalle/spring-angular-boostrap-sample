package com.eoutletz.web;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eoutletz.domain.User;
import com.eoutletz.repository.UserRepository;

@Controller
public class UserController 
{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserRepository userRepository;
	
	@Inject
	@Named("authenticationProviderJdbcImpl")
	private AuthenticationProvider authenticationProvider;
	
	@RequestMapping(method=RequestMethod.GET, value = "/login")
	public String showLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/signup")
	public String showSignUpPage(Map<String, Object> model)
	{
		logger.debug("Inside the signup page");
		model.put("userCommand", new User());
		return "signup";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/signup")
	public String processSignup(@Valid @ModelAttribute("userCommand") User userCommand, BindingResult bindingResult, Map<String, Object> model) 
	{
		logger.debug("Signup Form found: " + userCommand);
		
		// Check if the username already exists
		boolean usernameExists = false;
		if(StringUtils.isNotBlank(userCommand.getEmail()))
		{
			usernameExists = userRepository.getUserCountWithEmail(userCommand.getEmail()) > 0 ? true : false;
			
			if(usernameExists)
			{
				bindingResult.rejectValue("email", "uniqueviolation", "Email already exists");
			}
		}
		
		if(bindingResult.hasErrors() || usernameExists)
		{
			return "signup";
		}
		
		// Now that all the validation has been passed save the user
		User user = new User();
		user.setEmail(userCommand.getEmail());
		user.setFirstName(userCommand.getFirstName());
		user.setLastName(userCommand.getLastName());
		String hashedPwd = BCrypt.hashpw(userCommand.getPassword(), BCrypt.gensalt(12));
		user.setPassword(hashedPwd); 
		user = userRepository.save(user);
		
		// Now that we have saved the user, let's authenticate him
		Authentication authentication = new UsernamePasswordAuthenticationToken(userCommand.getEmail(), userCommand.getPassword());
		authentication = authenticationProvider.authenticate(authentication);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		model.put("user", user);
		
		return "redirect:home";
	}
}
