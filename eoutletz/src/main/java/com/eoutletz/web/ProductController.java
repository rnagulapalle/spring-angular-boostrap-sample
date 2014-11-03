package com.eoutletz.web;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eoutletz.domain.Product;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(method=RequestMethod.GET, value = "/product")
	public String showProductUploadPage(Map<String, Object> model)
	{
		logger.debug("Inside the upload page");
		model.put("prodCommand", new Product());
		return "product";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/product")
	public String processUpload(@Valid @ModelAttribute("prodCommand") Product prodCommand, BindingResult bindingResult, Map<String, Object> model) 
	{
		logger.debug("upload Form found: " + prodCommand);
		
//		// Check if the username already exists
//		boolean usernameExists = false;
//		if(StringUtils.isNotBlank(userCommand.getEmail()))
//		{
//			usernameExists = userRepository.getUserCountWithEmail(userCommand.getEmail()) > 0 ? true : false;
//			
//			if(usernameExists)
//			{
//				bindingResult.rejectValue("email", "uniqueviolation", "Email already exists");
//			}
//		}
//		
//		if(bindingResult.hasErrors() || usernameExists)
//		{
//			return "signup";
//		}
//		
//		// Now that all the validation has been passed save the user
//		User user = new User();
//		user.setEmail(userCommand.getEmail());
//		user.setFirstName(userCommand.getFirstName());
//		user.setLastName(userCommand.getLastName());
//		String hashedPwd = BCrypt.hashpw(userCommand.getPassword(), BCrypt.gensalt(12));
//		user.setPassword(hashedPwd); 
//		user = userRepository.save(user);
//		
//		// Now that we have saved the user, let's authenticate him
//		Authentication authentication = new UsernamePasswordAuthenticationToken(userCommand.getEmail(), userCommand.getPassword());
//		authentication = authenticationProvider.authenticate(authentication);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		model.put("user", user);
		
		return "product";
	}
}
