package com.ktds.brief.serviceImpl;

import java.io.File;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ktds.brief.service.SttSummaryService;

import lombok.RequiredArgsConstructor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@RequiredArgsConstructor
@Service
public class SttSummaryServiceImpl implements SttSummaryService {
	
	@Value("${kakao.stt.key}")
	private String sttKey;
	
	@Override
	public String getSttSum(String input) throws Exception {
		
		MediaType mType = MediaType.parse("audio/wav");
		OkHttpClient client = new OkHttpClient();
		
		File fis = new File(input);
		
		RequestBody requestBody = RequestBody.create(mType, fis);
		
		//post 객체 생성 
		Request request = new Request.Builder()
		        .addHeader("Authorization", "KakaoAK " + sttKey)
		        .addHeader("Content-type:", "application/octet-stream")
		        .addHeader("X-DSS-Service", "DICTATION")
		        .url("https://kakaoi-newtone-openapi.kakao.com/v1/recognize")
		        .post(requestBody) // how to build request body?
		        .build();	
		
		//request send
		Response response = client.newCall(request).execute();
		
		//response
		String res = response.body().string();
				
		//StringToJson
		String [] temp = res.split("finalResult\",")[1].split("------");
		String json = "{"+temp[0];
				
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json);
		JSONObject j = (JSONObject)obj;
		String result = (String) j.get("value");
				
		return result;
	}


}
