package com.eoutletz.web;

import java.beans.PropertyEditorSupport;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.eoutletz.domain.Sale;
import com.eoutletz.domain.ShippingCharge;
import com.eoutletz.domain.Size;
import com.eoutletz.repository.CategoryRepository;
import com.eoutletz.repository.PartnerRepository;
import com.eoutletz.repository.ProductRepository;
import com.eoutletz.repository.SaleRepository;
import com.eoutletz.repository.ShippingChargeRepository;
import com.eoutletz.repository.SizeRepository;
import com.eoutletz.service.ProductService;

/**
 * TODO: need to re-factor this code as it has lot of repetitive code
 * 
 * @author rnagulapalle
 *
 */
@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private SaleRepository saleRepository;
	
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
	
	@ModelAttribute("salePercentages")
    public List<Sale> getSalePercentages(){
        return (List<Sale>) saleRepository.findAll();
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
	public String showProduct(Map<String, Object> model, HttpServletRequest request){
		
		logger.debug("Inside the upload page");
		HttpSession session = request.getSession();
		//remove product from session if exists
		//TODO:write helper to clean all sessions and maintain sessions keys in enum
		if(session.getAttribute("product") != null)
			session.removeAttribute("product");
		
		if(session.getAttribute("action") != null)
			session.removeAttribute("action");
		
		Product prodCommand = new Product();
		model.put("message", "Add your product");
		model.put("action", "add");
		model.put("prodCommand", prodCommand);
		
		return "product";
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/product/{id}")
	public String editProduct(@PathVariable("id")String id, Map<String, Object> model, HttpServletRequest request){
		
		logger.debug("Inside the upload page");
		if(id == null || "".equals(id)){
			model.put("message", "Add your product");
			model.put("action", "add");
			model.put("prodCommand", new Product());
		}else{
			//TODO check product belongs to partner to prevent other partners not updating products
			Product prodCommand = productRepository.findOne(Long.parseLong(id));
			//put prod id in session and use that at the time of update rather then creating new prod
			HttpSession session = request.getSession();
			session.setAttribute("product", prodCommand);
			session.setAttribute("action", "update");
			
			model.put("message", "Update your product");
			model.put("action", "update");
			model.put("prodCommand", prodCommand);
		}
		return "product";
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/clone/{id}")
	public String clnoeProduct(@PathVariable("id")String id, Map<String, Object> model, HttpServletRequest request){
		
		logger.debug("Inside the upload page");
		if(id == null || "".equals(id)){
			model.put("message", "Add your product");
			model.put("action", "add");
			model.put("prodCommand", new Product());
		}else{
			//TODO check product belongs to partner to prevent other partners not updating products
			Product prodCommand = productRepository.findOne(Long.parseLong(id));
			//put prod id in session and use that at the time of update rather then creating new prod
			HttpSession session = request.getSession();
			session.setAttribute("product", prodCommand);
			session.setAttribute("action", "copy");
			
			model.put("message", "Copy from existing product");
			model.put("action", "copy");
			model.put("prodCommand", prodCommand);
		}
		return "product";
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/sale/{id}")
	public String saleProduct(@PathVariable("id")String id, Map<String, Object> model, HttpServletRequest request){
		
		logger.debug("Inside the upload page");
		if(id == null || "".equals(id)){
			model.put("message", "Add your product");
			model.put("action", "add");
			model.put("prodCommand", new Product());
		}else{
			//TODO check product belongs to partner to prevent other partners not updating products
			Product prodCommand = productRepository.findOne(Long.parseLong(id));
			//put prod id in session and use that at the time of update rather then creating new prod
			HttpSession session = request.getSession();
			session.setAttribute("product", prodCommand);
			session.setAttribute("action", "sale");
			
			model.put("message", "Add your product to sale");
			model.put("action", "sale");
			model.put("prodCommand", prodCommand);
		}
		return "product";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/product")
	public String processUpload(@Valid @ModelAttribute("prodCommand") final Product prodCommand, @RequestParam(value = "file", required = false) final MultipartFile[] files, final BindingResult bindingResult, final Map<String, Object> model, final HttpServletRequest request, final RedirectAttributes redirectAttributes) {

		if(bindingResult.hasErrors()){
			logger.error(bindingResult.toString());
			return "product";
		}
		
		//TODO: modify this method to handle based on action value
		//if action is not set default is add
		HttpSession session = request.getSession();
		String action = (String) session.getAttribute("action");
		if(action == null)
			action = "add";
		
		switch (action) {
			
			case "copy":
				
				return copyProduct(session, prodCommand, files, redirectAttributes);
				
			case "sale":
				
				return markdownProduct(session, prodCommand, files, redirectAttributes);
				
			case "update":
				return updateProduct(session, prodCommand, files, redirectAttributes);
				
			case "add":
				return addProduct(session, prodCommand, files, redirectAttributes);

				
		}

		return "product";
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
	}
	
	/**
	 * this method handles adding a product
	 * 
	 * @param session
	 * @param prodCommand
	 * @param files
	 * @param redirectAttributes
	 * @return
	 */
	private String addProduct(final HttpSession session, final Product prodCommand, final MultipartFile[] files, final RedirectAttributes redirectAttributes){
		
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
//    			//check session prod_id exists in session
//    			if(session.getAttribute("product") != null){
//    				Product product = (Product) session.getAttribute("product");
//    				prodCommand.setId(product.getId());
//    				prodCommand.setCreatedTime(product.getCreatedTime());
//    			}
    			productService.saveProduct(prodCommand, images);
    			redirectAttributes.addFlashAttribute("message", "Successfully saved..");
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
	
	/**
	 * this method handles updating a product
	 * 
	 * @param session
	 * @param prodCommand
	 * @param files
	 * @param redirectAttributes
	 * @return
	 */
	private String updateProduct(final HttpSession session, final Product prodCommand, final MultipartFile[] files, final RedirectAttributes redirectAttributes){
		
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
    			//check session prod_id exists in session
    			if(session.getAttribute("product") != null){
    				Product product = (Product) session.getAttribute("product");
    				prodCommand.setId(product.getId());
    				prodCommand.setCreatedTime(product.getCreatedTime());
    			}
    			productService.saveProduct(prodCommand, images);
    			redirectAttributes.addFlashAttribute("message", "Successfully saved..");
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

	/**
	 * this method handles creating a new product from existing product
	 * 
	 * @param session
	 * @param prodCommand
	 * @param files
	 * @param redirectAttributes
	 * @return
	 */
	private String copyProduct(final HttpSession session, final Product prodCommand, final MultipartFile[] files, final RedirectAttributes redirectAttributes){
		
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
//    			//check session prod_id exists in session
//    			if(session.getAttribute("product") != null){
//    				Product product = (Product) session.getAttribute("product");
//    				prodCommand.setId(product.getId());
//    				prodCommand.setCreatedTime(product.getCreatedTime());
//    			}
    			productService.saveProduct(prodCommand, images);
    			redirectAttributes.addFlashAttribute("message", "Successfully saved..");
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
	
	/**
	 * this method handles mark down a product price
	 * 
	 * @param session
	 * @param prodCommand
	 * @param files
	 * @param redirectAttributes
	 * @return
	 */
	private String markdownProduct(final HttpSession session, final Product prodCommand, final MultipartFile[] files, final RedirectAttributes redirectAttributes){
		
		String fileName = null;
		Calendar cal = Calendar.getInstance();
		//StringBuffer basePath = request.getRequestURL();
		//TODO: hard coded image path on local server
		String basePath = "http://localhost:8080/images/";
		Set<Image> images = new java.util.HashSet<Image>(0);
		
		//TODO:raad partner data from session
		Partner partner = partnerRepository.findOne(1l);
    		
    		//process form data
    		logger.debug("sale Form found: " + prodCommand);
    		
    		logger.debug(prodCommand.getDescription());
    		
    		prodCommand.setPartner(partner);
    		
    		try{
    			//check session prod_id exists in session
    			if(session.getAttribute("product") != null){
    				Product product = (Product) session.getAttribute("product");
    				product.setSale(prodCommand.getSale());
    				productService.saveProduct(product, images);
        			redirectAttributes.addFlashAttribute("message", "Successfully saved..");
        			return "redirect:partner";
    			}
    			
    			return "product";
    		}catch(org.hibernate.exception.ConstraintViolationException e){
    			//TODO: handle sql exceptions
    			logger.error("Error", e);
    			return "product";
    		}catch (org.springframework.dao.DataIntegrityViolationException e) {
    			//TODO: handle sql exceptions
    			logger.error("Error", e);
    			return "product";
			}
        
	}

	
}
