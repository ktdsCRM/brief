package com.ktds.brief.controller;

import java.io.File;

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
//	final private OcrSucmmaryService ocrSucmmaryService;

//	//텍스트 추출
//	@RequestMapping(value = "/export", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json; charset=utf-8")
//	public Object ocrSummary(@RequestParam("soundFile") MultipartFile multipartFiles) throws Exception{
//		String UPLOAD_PATH = "C://Users/82103/Desktop/soundFiles/";
//		String originalfileName = multipartFiles.getOriginalFilename();
//		String filePath = UPLOAD_PATH+originalfileName;
//		File dest = new File(filePath);//파일을 저장하기 위한 파일 객체 생성
//		multipartFiles.transferTo(dest);//파일 저장
//		String sttRes = sttSummaryService.getSttSum(filePath);
//		return new ResponseEntity<>(sttRes, HttpStatus.OK);
//	}
	
	//텍스트 요약
	@RequestMapping(value = "/sum", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json; charset=utf-8")
	public Object textSummary(@RequestBody String input) throws Exception{
		String textRes = textSummaryService.getTextSum(input);
		return new ResponseEntity<>(textRes, HttpStatus.OK);	
	}

}
