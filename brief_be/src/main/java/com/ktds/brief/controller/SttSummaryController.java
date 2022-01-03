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
@RequestMapping("/stt")
@RestController
public class SttSummaryController {

	final private SttSummaryService sttSummaryService;
	final private TextSummaryService textSummaryService; 
	String fileName = "";
	
	//텍스트 추출
	@RequestMapping(value = "/export", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json; charset=utf-8")
	public Object textSummary(@RequestParam("soundFile") MultipartFile multipartFiles) throws Exception{

		String UPLOAD_PATH = "C://Users/82105/Desktop/soundFiles/";
		String originalfileName = multipartFiles.getOriginalFilename();
		String filePath = UPLOAD_PATH+originalfileName;
		File dest = new File(filePath);//파일을 저장하기 위한 파일 객체 생성
		multipartFiles.transferTo(dest);//파일 저장
		fileName = originalfileName;
		String sttRes = sttSummaryService.getSttSum(filePath);
		return new ResponseEntity<>(sttRes, HttpStatus.OK);
	}
	
	//텍스트 요약
	@RequestMapping(value = "/sum", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json; charset=utf-8")
	public Object textSummary(@RequestBody String text) throws Exception{
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(text);
		JSONObject j = (JSONObject)obj;
		String input = (String) j.get("input");
		String type = "stt";
		String textRes = textSummaryService.getTextSum(input, type, fileName);

		return new ResponseEntity<>(textRes, HttpStatus.OK);
	}

}
