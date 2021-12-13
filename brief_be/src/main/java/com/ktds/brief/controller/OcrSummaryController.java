package com.ktds.brief.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.brief.service.TextSummaryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/textSummary")
@RestController
public class OcrSummaryController {

	final private TextSummaryService testSummaryService;
	
	@PostMapping("/sum")
	public String textSum(@RequestBody String text) {
		String s = text;
		return text;
	}

}
