package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.OrderTracking;

@RepositoryRestResource(collectionResourceRel = "trackorders", path = "trackorders")
public interface OrderTrackingRepository extends PagingAndSortingRepository<OrderTracking, Long>{

}
