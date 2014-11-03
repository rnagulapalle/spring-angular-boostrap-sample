package com.eoutletz.web;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("/product")
	public String home(Principal principal, HttpServletRequest request, Map<String, Object> model)
	{
		String page = "product";
		
		return page;
	}
}
