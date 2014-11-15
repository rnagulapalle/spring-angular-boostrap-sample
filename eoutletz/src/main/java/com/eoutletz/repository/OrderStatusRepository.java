package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.OrderStatus;

@RepositoryRestResource(collectionResourceRel = "orderStatuses", path = "orderStatuses")
public interface OrderStatusRepository extends PagingAndSortingRepository<OrderStatus, Long>{
	
}