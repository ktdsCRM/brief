package com.ktds.brief.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.brief.service.TextSummaryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/text")
@RestController
public class TextSummaryController {

	final private TextSummaryService textSummaryService; 
	
	@RequestMapping(value = "/sum", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json; charset=utf-8")
	public Object textSummary(@RequestBody String text) throws Exception{
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(text);
		JSONObject j = (JSONObject)obj;
		String input = (String) j.get("input");
		String type = "text";
		String textRes = textSummaryService.getTextSum(input, type, null);

		return new ResponseEntity<>(textRes, HttpStatus.OK);
	}

}
