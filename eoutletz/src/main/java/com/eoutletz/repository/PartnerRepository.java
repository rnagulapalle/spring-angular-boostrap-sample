package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Partner;

@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Long>{

}
