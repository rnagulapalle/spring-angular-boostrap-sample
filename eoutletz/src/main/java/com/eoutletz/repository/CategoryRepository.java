package com.eoutletz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.eoutletz.domain.Category;
import com.eoutletz.domain.Product;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends
		PagingAndSortingRepository<Category, Long> {

	@Query("select count(*) from Category where name = ?")
	public int getCountWithCategory(String name);

	@Query("select c.products from Category c where c.name = :name")
	@RestResource(path = "prods")
	public List<Product> findAllProductsByCategory(@Param("name") String name);
}