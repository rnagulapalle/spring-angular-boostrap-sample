package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.PartnerContact;

@RepositoryRestResource(collectionResourceRel = "pcontacts", path = "pcontacts")
public interface PartnerContactRespository extends PagingAndSortingRepository<PartnerContact, Long>{

}