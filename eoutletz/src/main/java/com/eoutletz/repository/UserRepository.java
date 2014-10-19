package com.eoutletz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository  extends PagingAndSortingRepository<User, Long>{

	@Query("select count(*) from User where email = ?")
	public int getUserCountWithEmail(String email);
	
}
