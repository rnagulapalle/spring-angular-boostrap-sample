package com.eoutletz.web;

import java.beans.PropertyEditorSupport;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eoutletz.domain.Product;
import com.eoutletz.domain.Size;

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
		logger.debug(prodCommand.getDescription());
		model.put("product", new Product());
		return "product";
	}
	
//	@InitBinder
//	protected void initBinder(HttpServletRequest request, WebDataBinder binder) throws Exception {
//	    binder.registerCustomEditor(Size.class, "size", new PropertyEditorSupport() {
//	    @Override
//	    public void setAsText(String text) {
//	    	Size size = new Size();
//	    	size.setSize(text);
//	        setValue(size);
//	    }
//	 });
//	}
	
	class SizePropertyEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) {
		Size size = new Size();
		size.setSize(text);
		setValue(size);
		}
	}
	
	@InitBinder
	public void initBinderAll(WebDataBinder binder) {
		binder.registerCustomEditor(Size.class,  new SizePropertyEditor());
	}
}
