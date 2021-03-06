package com.ktds.brief.controller;


import java.io.File;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ktds.brief.service.SttSummaryService;
import com.ktds.brief.service.TextSummaryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/ocr")
@RestController
public class OcrSummaryController {
	
	final private TextSummaryService textSummaryService;
	
	//텍스트 요약
	@RequestMapping(value = "/sum", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json; charset=utf-8")
	public Object textSummary(@RequestBody String text) throws Exception{

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(text);
		JSONObject j = (JSONObject)obj;
		String input = (String) j.get("input");
		String fileName = (String) j.get("filename");
		String type = "ocr";
		String textRes = textSummaryService.getTextSum(input,type,fileName);

		return new ResponseEntity<>(textRes, HttpStatus.OK);	
	}

}
