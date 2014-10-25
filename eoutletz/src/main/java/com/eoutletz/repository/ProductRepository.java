package com.eoutletz.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Partner;
import com.eoutletz.domain.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository   extends PagingAndSortingRepository<Product, Long> {

	@Query("from Product order by updatedTime desc")
	public List<Product> findLatestProducts();
	
	@Query
    public Page<Product> findByPartner(Partner partner, Pageable pageable);

}
