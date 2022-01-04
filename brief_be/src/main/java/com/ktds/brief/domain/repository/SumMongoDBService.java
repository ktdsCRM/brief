package com.ktds.brief.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ktds.brief.domain.entity.Sum;

@Service
public class SumMongoDBService {
	
	@Autowired
	private SumMongoDBRepository sumMongoDBRepository;
	
	
	public List<Sum> findAll() {
		
		return sumMongoDBRepository.findBy(PageRequest.of(0, 10));
		
	}
	


}
