package com.ktds.brief.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ktds.brief.domain.entity.Sum;
import com.ktds.brief.domain.repository.SumMongoDBRepository;
import com.ktds.brief.service.TextSummaryService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TextSummaryServiceImpl implements TextSummaryService {
	
	@Autowired
	final private SumMongoDBRepository sumMongoDBRepository;
	
	@Override
	public String getTextSum(String input, String type, String fileName) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		
		String url = "http://localhost:8080/summary";
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("full_text", input);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

		//input data
		ResponseEntity<String> res = restTemplate.postForEntity(url, parameters, String.class);
		
		//create date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();		
		String realTime = simpleDateFormat.format(time);

		Sum entity = Sum.builder().text(input).sumText(res.getBody()).type(type).fileName(fileName).createDate(realTime).build();
		sumMongoDBRepository.save(entity);
		
		return res.getBody();
	}


}
