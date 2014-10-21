package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Phone;

@RepositoryRestResource(collectionResourceRel = "phones", path = "phones")
public interface PhoneRespository extends PagingAndSortingRepository<Phone, Long>{

}
