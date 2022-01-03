package com.ktds.brief.domain.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Document(collection="sum")
public class Sum {
//	@Id
//	private long id;
	
	private String text;
	private String sumText;
	private String type;
	private String fileName;
	private String createDate;
	
	@Builder
	public Sum(String text, String sumText, String type, String fileName, String createDate) {
		this.text = text;
		this.sumText = sumText;
		this.type = type;
		this.fileName = fileName;
		this.createDate = createDate;
	}

	
}
