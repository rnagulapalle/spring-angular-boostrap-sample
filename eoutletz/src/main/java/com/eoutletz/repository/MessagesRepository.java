package com.eoutletz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eoutletz.domain.Messages;

@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
public interface MessagesRepository extends PagingAndSortingRepository<Messages, Long>{

	@Query("select m from Messages m where m.userTo.id = ?1")
	public List<Messages> findByUserTo(long userId);
}
