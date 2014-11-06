package com.eoutletz.web;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eoutletz.domain.Category;
import com.eoutletz.domain.Product;
import com.eoutletz.domain.Size;
import com.eoutletz.repository.CategoryRepository;
import com.eoutletz.repository.SizeRepository;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private SizeRepository sizeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@ModelAttribute("categories")
    public List<Category> getCategories(){
        return (List<Category>) categoryRepository.findAll();
    }
	
	@ModelAttribute("sizes")
    public List<Size> getSizes(){
        return (List<Size>) sizeRepository.findAll();
    }
	
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
			Size size = sizeRepository.findOne(Long.parseLong(text));
			setValue(size);
		}
	}
	
	@InitBinder
	public void initBinderAll(WebDataBinder binder) {
		binder.registerCustomEditor(Size.class, "size", new SizePropertyEditor());
		final List<Category> categories = (List<Category>) categoryRepository.findAll();
		binder.registerCustomEditor(Set.class,"categories", new CustomCollectionEditor(Set.class){
            protected Object convertElement(Object element){
                if (element instanceof String) {
                    Category category = categories.get(Integer.parseInt(element.toString()));

                    return category;
                }
                return null;
            }
        });
	}
}
