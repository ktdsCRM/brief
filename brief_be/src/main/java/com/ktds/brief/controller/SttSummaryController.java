package com.ktds.brief.controller;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ktds.brief.service.SttSummaryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/stt")
@RestController
public class SttSummaryController {

	final private SttSummaryService sttSummaryService;
	
	@RequestMapping(value = "/sum", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json; charset=utf-8")
	public Object textSummary(@RequestBody MultipartFile multipartFiles) throws Exception{
		
		String UPLOAD_PATH = "/Users/ohjihye/Desktop/myupload";
		String originalfileName = multipartFiles.getOriginalFilename();
		String filePath = UPLOAD_PATH+originalfileName;
		
		File dest = new File(filePath);//파일을 저장하기 위한 파일 객체 생
		multipartFiles.transferTo(dest);//파일 저장
		
		String sttRes = sttSummaryService.getSttSum(filePath);
		
		return new ResponseEntity<>(sttRes, HttpStatus.OK);
	}

}
