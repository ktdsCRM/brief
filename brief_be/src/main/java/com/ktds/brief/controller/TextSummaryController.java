package com.ktds.brief.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ktds.brief.domain.entity.Sum;
import com.ktds.brief.domain.repository.SumMongoDBRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/text")
@RestController
public class TextSummaryController {
	
	@Autowired
	private SumMongoDBRepository sumMongoDBRepository;
	
	
	@RequestMapping(value = "/sum", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json; charset=utf-8")
	public String textSummary(@RequestBody String input) throws Exception{
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		
		String url = "http://localhost:8080/summary";
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("full_text", input);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

		ResponseEntity<String> res = restTemplate.postForEntity(url, parameters, String.class);
		System.out.println(input);
		System.out.println(res.getBody());

		Sum entity = Sum.builder().text(input).sumText(res.getBody()).build();
		sumMongoDBRepository.save(entity);
		
		return res.getBody();
		
	}


}
