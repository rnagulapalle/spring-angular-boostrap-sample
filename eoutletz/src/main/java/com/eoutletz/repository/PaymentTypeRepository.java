package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.PaymentType;


@RepositoryRestResource(collectionResourceRel = "ptypes", path = "ptypes")
public interface PaymentTypeRepository extends PagingAndSortingRepository<PaymentType, Long>{

}
