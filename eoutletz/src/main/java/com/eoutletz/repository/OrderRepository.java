package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Orders;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepository extends PagingAndSortingRepository<Orders, Long>{

}
