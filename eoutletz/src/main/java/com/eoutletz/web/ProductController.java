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
		Product prodCommand = new Product();
		model.put("prodCommand", prodCommand);
		return "product";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/product")
	public String processUpload(@Valid @ModelAttribute("prodCommand") Product prodCommand, BindingResult bindingResult, Map<String, Object> model) 
	{
		logger.debug("upload Form found: " + prodCommand);

		model.put("product", new Product());
		return "product";
	}
}
