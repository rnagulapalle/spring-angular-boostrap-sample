package com.eoutletz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.AddressType;

@RepositoryRestResource(collectionResourceRel = "addresstypes", path = "addresstypes")
public interface AddressTypeRepository  extends CrudRepository<AddressType, Long> {

}
