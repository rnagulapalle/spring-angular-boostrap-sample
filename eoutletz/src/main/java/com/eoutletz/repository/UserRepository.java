package com.eoutletz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.eoutletz.domain.Product;
import com.eoutletz.domain.User;

@Repository
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	@Query("select count(*) from User where email = ?")
	public int getUserCountWithEmail(String email);

	
//	@Query("select u from User u where u.email = :email and u.password = :password")
//	@RestResource(path = "login")
//	public User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	@Query("select u from User u where LOWER(u.email) = LOWER(?1)")
	public User findByEmail(String email);

	@Query("select p.id from Product p join p.userLikes u where u.id = ?1")
	@RestResource(rel = "byUser", path = "byUser")
	List<Product> findProductsLikedById(long id);
}
