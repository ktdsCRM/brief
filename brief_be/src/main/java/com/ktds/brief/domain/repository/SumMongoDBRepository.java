package com.ktds.brief.domain.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ktds.brief.domain.entity.Sum;

public interface SumMongoDBRepository extends MongoRepository<Sum, String>{

}
