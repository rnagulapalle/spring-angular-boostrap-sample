package com.eoutletz.service;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eoutletz.domain.PasswordRequest;
import com.eoutletz.repository.PasswordRequestRepository;


@Service
@Transactional(propagation = Propagation.REQUIRED) 
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private PasswordRequestRepository passwordRequestRepository;
	
	public void saveToken(final PasswordRequest passwordRequest) throws ConstraintViolationException, DataIntegrityViolationException{
		logger.info("saving product");
		if(passwordRequestRepository.findByEmail(passwordRequest.getEmail()) != null){
			//delete previous token if exists
			passwordRequestRepository.deletByEmail(passwordRequest.getEmail());
		}
		passwordRequestRepository.save(passwordRequest);
	}
}