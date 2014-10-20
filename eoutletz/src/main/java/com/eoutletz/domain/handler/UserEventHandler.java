package com.eoutletz.domain.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.eoutletz.domain.User;
import com.eoutletz.repository.UserRepository;

/*
 * {
		  "firstName": "Sudha",
		  "lastName" : "Belida",
		  "email" : "Sudha.Belida@gmail.com",
		  "password" : "12345"
		}
 */

@RepositoryEventHandler(User.class)
public class UserEventHandler 
{
	private UserRepository userRepository;
	
	public UserEventHandler(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@HandleBeforeSave
	 public void handleBeforeSave(User u) 
	 {
		 System.out.println("THIS GOT SAVED");
	 }
	 
	 
	 @HandleBeforeCreate
	 public void handleBeforeCreate(User user) 
	 {
		 // Before we create a user, we need to encrypt the password
		String hashedPwd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
		user.setPassword(hashedPwd); 
	 }
}
