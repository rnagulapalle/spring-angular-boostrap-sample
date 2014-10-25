package com.eoutletz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Partner;

@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Long>{

	@Query("select count(*) from Partner where email = ?")
	public int getPartnerCountWithEmail(String email);
}
