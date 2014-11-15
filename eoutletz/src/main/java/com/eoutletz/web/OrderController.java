package com.eoutletz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eoutletz.domain.OrderStatus;
import com.eoutletz.domain.Orders;
import com.eoutletz.domain.Product;
import com.eoutletz.repository.OrderRepository;
import com.eoutletz.repository.OrderStatusRepository;

@Controller
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderStatusRepository orderStatusRepository;

	@ModelAttribute("statuses")
    public List<OrderStatus> getSizes(){
        return (List<OrderStatus>) orderStatusRepository.findAll();
    }
	
	@RequestMapping(method=RequestMethod.GET, value = "/order/{id}")
	public ModelAndView orderDetails(@PathVariable("id")String id){
		//TODO: read partner from session
		//check this order belongs to logged in partner
		Orders order = orderRepository.findOne(Long.parseLong((id)));

		ModelAndView modelAndView = new ModelAndView("orderDetails");
		modelAndView.addObject("order", order);

		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/order/status/{id}")
	public ModelAndView orderStatus(@PathVariable("id")String id, HttpServletRequest request){
		//TODO: read partner from session
		//check this order belongs to logged in partner
		Orders order = orderRepository.findOne(Long.parseLong((id)));
		if(order == null) throw new NullPointerException("No such order exists");
		//check this session varaibale in update call
		HttpSession session = request.getSession();
		session.setAttribute("order", order);

		ModelAndView modelAndView = new ModelAndView("orderUpdate");
		modelAndView.addObject("orderCommand", order);

		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/order")
	public ModelAndView updateStatus(@Valid @ModelAttribute("orderCommand") final Orders orderCommand, final BindingResult bindingResult, final HttpServletRequest request, final RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			ModelAndView modelAndView = new ModelAndView("orderUpdate");
			modelAndView.addObject("orderCommand", orderCommand); 
			return modelAndView;
		}
		//TODO: read partner from session
		//check this order belongs to logged in partner
		HttpSession session = request.getSession();
		Orders orderInSession = (Orders) session.getAttribute("order");
		if(orderInSession == null) throw new NullPointerException("No such order exists in session");
		
		orderInSession.setTrackingNumber(orderCommand.getTrackingNumber());
		orderInSession.setOrderStatus(orderCommand.getOrderStatus());
		orderRepository.save(orderInSession);
		//TODO: send an email to user about new status
		redirectAttributes.addFlashAttribute("message", "Successfully saved..");
		return new ModelAndView("redirect:partner");
	}
}
