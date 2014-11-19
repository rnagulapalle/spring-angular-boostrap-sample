package com.eoutletz.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eoutletz.domain.Messages;
import com.eoutletz.domain.Product;
import com.eoutletz.repository.MessagesRepository;

@Controller
@RequestMapping("/message")
public class MessagesController {

	@Autowired
	private MessagesRepository messagesRepository;
	
	@RequestMapping(method=RequestMethod.GET, value = "/{id}")
	public ModelAndView showMessage(@PathVariable("id")String id){
		
		if(id == null || "".equalsIgnoreCase(id)) throw new NullPointerException("no such message exists!");
		long messageId = Long.parseLong(id);
		//TODO: read partner from session
		Messages message = messagesRepository.findOne(messageId);
	
		
		ModelAndView modelAndView = new ModelAndView("messages");
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/create")
	public ModelAndView createMessage(HttpServletRequest request){
		
		ModelAndView modelAndView = new ModelAndView("messageSend");
		modelAndView.addObject("messageCommand", new Messages());
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/reply/{id}")
	public ModelAndView replyMessage(@PathVariable("id")String id, HttpServletRequest request){
		
		if(id == null || "".equalsIgnoreCase(id)) throw new NullPointerException("no such message exists!");
		long messageId = Long.parseLong(id);
		//TODO: read partner from session
		Messages message = messagesRepository.findOne(messageId);
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		ModelAndView modelAndView = new ModelAndView("messageSend");
		modelAndView.addObject("messageCommand", message);
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/send")
	public ModelAndView replyMessageTo(@Valid @ModelAttribute("prodCommand") final Messages messageCommand, final HttpServletRequest request, final RedirectAttributes redirectAttributes){
		
		//read message from session and process message
		HttpSession session = request.getSession();
		Messages messageInSession = (Messages) session.getAttribute("message");
		//create a new message if message is null or create a message with parent_message_id
		//unset session after creating a message

		if(messageInSession != null){
			//this is reply block
			messageCommand.setParentMessageId(messageInSession.getId());
			messageCommand.setUserFrom(messageInSession.getUserTo());
			messageCommand.setUserTo(messageInSession.getUserFrom());
			messageCommand.setRead("N");
			//unset session
			session.removeAttribute("message");
		}else{
			//new block code
			//set from_user and to_user based on login userId
			//only buyers should initiate a conversation
		}
		
		messagesRepository.save(messageCommand);
		
		redirectAttributes.addFlashAttribute("message", "Successfully performed action..");
		return new ModelAndView("redirect:/partner");
	}
}
