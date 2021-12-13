package com.ktds.brief.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*")
@RestController
public class TextSummaryController {
	
	@RequestMapping(value="/test", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String textSummary() throws Exception{
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		
		String url = "http://localhost:8080/summary";
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("full_text", "보조금 집행 위법행위·지적사례 늘어특별감사반, 2017~2018년 축제 점검충주시가 민간에게 지원되는 보조사업의 대형축제와 관련해 선정·집행·정산 등 운영실태 전반에 대한 자체 감사를 실시할 계획이라고 밝혔다.이는 최근 민간보조사업의 증가와 더불어 보조금 집행관리에 대한 위법 부당 행위와 지적사례가 지속적으로 증가함에 따라, 감사를 통해 취약요인을 점검해 올바른 보조금 사용 풍토를 정착시키겠다는 취지다. 시는 감사담당관실과 기획예산과 보조금 관련 주무관으로 특별감사반을 편성해 2017년부터 2018년까지 집행된 축제성 보조금 집행에 대한 철저한 점검과 감사를 통해 부정 수급 및 부정 집행이 확인되면 엄정한 조치를 취할 방침이다. 시는 지난 15일부터 25일까지 10일간의 사전감사를 통해 보조금 실태를 파악한 후, 8월15일까지 세부감사를 진행할 예정이라고 전했다.축제성 관련 부정수급 유형을 보면 허위·기타 부정한 방법으로 보조금 신청, 사업 실적을 부풀려 보조금을 횡령·편취, 보조금 교부 목적과 다른 용도로 집행, 보조금으로 취득한 재산에 대해 지자체장의 승인없이 임의 처분 등이 해당된다.시는 불법보조금 근절과 효율적인 점검 및 적극적인 시민관심을 유도하기 위해 '지방보조금 부정수급 신고센터(☏850-5031)'를 설치 운영하고 있다. 지방보조금 부정수급 신고 시 직접방문 및 국민신문고(www.epeople.or.kr), 충주시홈페이지(www.chungju.or.kr)를 통해 접수하면 되고, 신고취지와 이유를 기재하고 부정행위와 관련한 증거자료를 제시하면 된다.단, 익명 신고는 접수치 않는다.시 관계자는 이번 자체 점검 및 감사를 통해 축제보조금이 제대로 쓰이는지에 대한 반성과 함께 보조금 집행의 투명성 및 행정의 신뢰성을 확보하는데 최선을 다하겠다고 말했다.한편. 시는 감사 및 예산부서 합동으로 컨설팅 위주의 상반기 보조금 특정감사(1월10일~20일)를 실시해 주의 11건, 시정 6건, 권고 1건을 자체 적발하고 조치한 바 있다.");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

		ResponseEntity<String> res = restTemplate.postForEntity(url, parameters, String.class);
		System.out.println(res.getBody());

		
		return res.getBody();
		
	}


}
