package com.eoutletz.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eoutletz.domain.Partner;
import com.eoutletz.repository.PartnerRepository;

@Controller
public class PartnerController {

	@Autowired
	private PartnerRepository partnerRepository;
	
	@RequestMapping(method=RequestMethod.GET, value = "/partner")
	public ModelAndView home(Principal principal, HttpServletRequest request){
		//TODO: read partner from session
		Partner partner = partnerRepository.findOne(1l);
		ModelAndView modelAndView = new ModelAndView("partner");
		modelAndView.addObject("partner", partner);
		
		
		return modelAndView;
	}
}
