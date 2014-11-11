package com.eoutletz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.eoutletz.domain.PasswordRequest;

@Repository
public interface PasswordRequestRepository extends PagingAndSortingRepository<PasswordRequest, Long>{

	@Query("select pr from PasswordRequest pr where token = ?1")
	public PasswordRequest findByToken(String token);
	
}
