package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository   extends PagingAndSortingRepository<Product, Long> {

}
