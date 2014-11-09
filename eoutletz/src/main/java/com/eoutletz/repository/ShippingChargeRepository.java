package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.ShippingCharge;

@RepositoryRestResource(collectionResourceRel = "shippingCharges", path = "shippingCharges")
public interface ShippingChargeRepository extends PagingAndSortingRepository<ShippingCharge, Long> {

}
