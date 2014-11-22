package com.eoutletz.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eoutletz.domain.Product;
import com.eoutletz.domain.User;
import com.eoutletz.repository.ProductRepository;
import com.eoutletz.repository.UserRepository;

/**
 * TODO: this class temp solution for custom REST API improve this class as per
 * REST standards( Spring HATEOAS)
 * https://blog.safaribooksonline.com/2013/09/30/rest-hypermedia/
 * https://github.com/olivergierke/spring-restbucks
 * 
 * @author rnagulapalle
 *
 */
@Controller
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

	private UserRepository userRepository;
	private @NonNull EntityLinks entityLinks;
	
	@Autowired
	private ProductRepository productRepository;

	@Inject
	void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	HttpEntity<Resource<User>> loadUser(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		if (user == null) {

			return new ResponseEntity<Resource<User>>(HttpStatus.NOT_FOUND);

		}
		Resource<User> userResponse = new Resource<User>(user);

		return new ResponseEntity<Resource<User>>(userResponse, HttpStatus.OK);
	}

	// TODO: build custom Resource
	@RequestMapping(method = RequestMethod.GET, value = "/likes/{userId}")
	@ResponseBody
	List<Long> loadUserLinkedProducts(@PathVariable Long userId) {
		List<Long> likes = userRepository.findProductsLikedById(userId);
		if (likes == null) {

			return new ArrayList<Long>();

		}

		return likes;
	}

	// TODO: build custom Resource
	//POST user like
	@RequestMapping(method = RequestMethod.PUT, value = "/likes/{prodId}")
	@ResponseBody
	ResponseEntity<Resource<Product>> postUserLinkedProduct(@PathVariable String prodId) {
		
		Product product = productRepository.findOne(Long.parseLong(prodId));
		
		if(product == null){
			return new ResponseEntity<Resource<Product>>(HttpStatus.NOT_FOUND);
		}
		Long likes = product.getLikes();
		if(likes == null)
			likes = 1l;
		else
			likes++;
		product.setLikes(likes);
		Set<User> user = new java.util.HashSet<>();
		//TODO: get logged in user from session
		User loggedInUser  = userRepository.findOne(1l);
		user.add(loggedInUser);
		product.setUserLikes(user);
		productRepository.save(product);
		
		Resource<Product> prodResponse = new Resource<Product>(product);
		//TODO: custom resource as successful
		return new ResponseEntity<Resource<Product>>(prodResponse, HttpStatus.OK);
		
	}
}
