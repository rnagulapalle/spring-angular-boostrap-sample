package com.eoutletz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Category;
import com.eoutletz.domain.Product;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends
		PagingAndSortingRepository<Category, Long> {

	@Query("select count(*) from Category where name = ?")
	public int getCountWithCategory(String name);

	@Query("select c.products from Category c where c.name = ?")
	public List<Product> findAllProductsByCategory(String name);
}