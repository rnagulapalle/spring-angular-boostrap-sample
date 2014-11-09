package com.eoutletz.web;

import java.beans.PropertyEditorSupport;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eoutletz.domain.Category;
import com.eoutletz.domain.Image;
import com.eoutletz.domain.Partner;
import com.eoutletz.domain.Product;
import com.eoutletz.domain.ShippingCharge;
import com.eoutletz.domain.Size;
import com.eoutletz.repository.CategoryRepository;
import com.eoutletz.repository.PartnerRepository;
import com.eoutletz.repository.ProductRepository;
import com.eoutletz.repository.ShippingChargeRepository;
import com.eoutletz.repository.SizeRepository;
import com.eoutletz.service.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private SizeRepository sizeRepository;
	
	@Autowired
	private ShippingChargeRepository shippingChargeRepository;
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("categories")
    public List<Category> getCategories(){
        return (List<Category>) categoryRepository.findAll();
    }
	
	@ModelAttribute("sizes")
    public List<Size> getSizes(){
        return (List<Size>) sizeRepository.findAll();
    }
	
	@ModelAttribute("shippingCharges")
    public List<ShippingCharge> getShippingCharges(){
        return (List<ShippingCharge>) shippingChargeRepository.findAll();
    }
	
	@RequestMapping(method=RequestMethod.GET, value = "/product")
	public String showProduct(Map<String, Object> model){
		
		logger.debug("Inside the upload page");
		Product prodCommand = new Product();
		model.put("message", "Add your product");
		model.put("prodCommand", prodCommand);
		
		return "product";
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/product/{id}")
	public String editProduct(@PathVariable("id")String id, Map<String, Object> model){
		
		logger.debug("Inside the upload page");
		//TODO check product belongs to partner
		Product prodCommand = productRepository.findOne(Long.parseLong(id));
		model.put("message", "Update your product");
		model.put("prodCommand", prodCommand);
		
		return "product";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/product")
	public String processUpload(@Valid @ModelAttribute("prodCommand") final Product prodCommand, @RequestParam(value = "file", required = false) final MultipartFile[] files, final BindingResult bindingResult, final Map<String, Object> model, final RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()){
			logger.error(bindingResult.toString());
			return "product";
		}
		String fileName = null;
		Calendar cal = Calendar.getInstance();
		//StringBuffer basePath = request.getRequestURL();
		//TODO: hard coded image path on local server
		String basePath = "http://localhost:8080/images/";
		Set<Image> images = new java.util.HashSet<Image>(0);
		
		//TODO:raad partner data from session
		Partner partner = partnerRepository.findOne(1l);
		
		if (files != null && files.length >0) {
    		for(int i =0 ;i< files.length; i++){
	            try {
	                fileName = files[i].getOriginalFilename();
	                if(fileName != null && StringUtils.isNotEmpty(fileName)){
		                byte[] bytes = files[i].getBytes();
		             // Creating the directory to store file
		                String rootPath = System.getProperty("catalina.home");
		                File dir = new File(rootPath + File.separator + "tmpFiles");
		                if (!dir.exists())
		                    dir.mkdirs();
		 
		                // Create the file on server
		                fileName = cal.getTimeInMillis() + fileName;
		                File serverFile = new File(dir.getAbsolutePath()
		                        + File.separator + fileName);
		                BufferedOutputStream buffStream = 
		                        new BufferedOutputStream(new FileOutputStream(serverFile));
		                buffStream.write(bytes);
		                buffStream.close();
		                //create an image object
		                Image image = new Image();
		                image.setImage(basePath + fileName);
		                images.add(image);
		                
		                logger.debug( "You have successfully uploaded " + fileName );
		                logger.info("Server File Location="
		                        + serverFile.getAbsolutePath());
		                
	                }
	            } catch (Exception e) {
	                logger.error( "You failed to upload " + fileName + ": " + e.getMessage() );
	            }
    		}
    		
    		//process form data
    		logger.debug("upload Form found: " + prodCommand);
    		
    		logger.debug(prodCommand.getDescription());
    		
    		prodCommand.setPartner(partner);
    		
    		try{
    			productService.saveProduct(prodCommand, images);
    			redirectAttributes.addFlashAttribute("message", "Successfully added..");
    			return "redirect:partner";
    		}catch(org.hibernate.exception.ConstraintViolationException e){
    			//TODO: handle sql exceptions
    			logger.error("Error", e);
    			return "product";
    		}catch (org.springframework.dao.DataIntegrityViolationException e) {
    			//TODO: handle sql exceptions
    			logger.error("Error", e);
    			return "product";
			}
        } else {
           // return "Unable to upload. File is empty.";
        	logger.error("File uploading failed and returning to product page");
        	return "product";
        }
	}

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
		//remove this is as its not working
//		binder.registerCustomEditor(Set.class,"images", new CustomCollectionEditor(Set.class){
//            protected Object convertElement(Object element){
//                if (element instanceof String) {
//                    //Category category = categories.get(Integer.parseInt(element.toString()));
//                    return element;
//                }
//                return null;
//            }
//        });
	}
}
