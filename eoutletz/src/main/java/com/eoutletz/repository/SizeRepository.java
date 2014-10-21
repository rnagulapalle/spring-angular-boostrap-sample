package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Size;

@RepositoryRestResource(collectionResourceRel = "sizes", path = "sizes")
public interface SizeRepository extends PagingAndSortingRepository<Size, Long>{
	
}
