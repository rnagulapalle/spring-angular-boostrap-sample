package com.eoutletz.web;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping("/home")
	public String home(Principal principal, HttpServletRequest request, Map<String, Object> model)
	{
		String page = "home";
		
		return page;
	}
}
