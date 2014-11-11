package com.eoutletz.service;


import java.util.Set;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eoutletz.domain.Image;
import com.eoutletz.domain.Product;
import com.eoutletz.repository.ImageRepository;
import com.eoutletz.repository.ProductRepository;
import com.eoutletz.web.ProductController;

@Service
@Transactional(propagation = Propagation.REQUIRED) 
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ImageRepository imagerepository;
	
	public void saveProduct(final Product product, final Set<Image> images) throws ConstraintViolationException, DataIntegrityViolationException{
		logger.info("saving product");
		Product newProd = productRepository.save(product);
		//set prod_id to all images before insert
		for(Image image : images){
			image.setProduct(newProd);
		}
		imagerepository.save(images);
	}
}
