package com.eoutletz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.eoutletz.domain.User;
import com.eoutletz.repository.custom.UserRepositoryCustom;

@Repository
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long>,
		UserRepositoryCustom {

	@Query("select count(*) from User where email = ?")
	public int getUserCountWithEmail(String email);

	// @Query("select u from User u where u.email = :email and u.password = :password")
	// @RestResource(path = "login")
	// public User findByEmailAndPassword(@Param("email") String email,
	// @Param("password") String password);

	@Query("select u from User u where LOWER(u.email) = LOWER(?1)")
	public User findByEmail(String email);

}
