package com.eoutletz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Image;
@RepositoryRestResource(collectionResourceRel = "images", path = "images")
public interface ImageRepository extends PagingAndSortingRepository<Image, Long>{
	

}
