package com.ktds.brief.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.brief.domain.entity.Sum;
import com.ktds.brief.domain.repository.SumMongoDBService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/board")
@RestController
public class BoardController {
	
	@Autowired
	private SumMongoDBService sumMongoDBService;
	
	@RequestMapping(value = "/info", method = {RequestMethod.GET}, produces = "application/json; charset=utf-8")
	public Object textSummary() throws Exception{
		
		List<Sum> allSum = sumMongoDBService.findAll();

		return new ResponseEntity<>(allSum, HttpStatus.OK);
	}

	

}
