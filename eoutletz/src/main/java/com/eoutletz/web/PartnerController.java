package com.eoutletz.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eoutletz.domain.Messages;
import com.eoutletz.domain.Orders;
import com.eoutletz.domain.Partner;
import com.eoutletz.domain.Product;
import com.eoutletz.domain.User;
import com.eoutletz.repository.MessagesRepository;
import com.eoutletz.repository.PartnerRepository;
import com.eoutletz.repository.UserRepository;

@Controller
public class PartnerController {

	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessagesRepository messageRepository;
	
	@RequestMapping(method=RequestMethod.GET, value = "/partner")
	public ModelAndView partner(){
		//TODO: read partner from session
		Partner partner = partnerRepository.findOne(1l);
		User user = userRepository.findOne(2l);
		
		
		Set<Product> products = partner.getProducts();
		//order by updatedTime
		List<Product> orderedProds=Product.asSortedList(products);
		
		Set<Orders> orders = partner.getOrders();
		//order by updatedTime
		List<Orders> orderedOrders=Orders.asSortedList(orders);

		ModelAndView modelAndView = new ModelAndView("partner");
		modelAndView.addObject("partner", partner);
		modelAndView.addObject("products", orderedProds);
		modelAndView.addObject("orders", orderedOrders);
		modelAndView.addObject("inbox", user.getMessagesTo());
		modelAndView.addObject("sent", user.getMessagesFrom());
		modelAndView.addObject("orders", orderedOrders);
		
		return modelAndView;
	}
}
