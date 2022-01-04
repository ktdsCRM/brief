package com.ktds.brief.domain.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ktds.brief.domain.entity.Sum;

public interface SumMongoDBRepository extends MongoRepository<Sum, String>{
	
	@Query(sort = "{createDate:-1}")
	List<Sum> findBy (Pageable pageable);
	
}
