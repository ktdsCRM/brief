package com.ktds.brief.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Document(collection="sum")
public class Sum {
	
	public static final String SEQUENCE_NAME = "sum_sequence";
	
	@Id
	private Long id;
	private String text;
	private String sumText;
	private String type;
	private String fileName;
	private String createDate;
	
	public void setId(Long id) {
		this.id=id;
	}
	
	@Builder
	public Sum(String text, String sumText, String type, String fileName, String createDate) {
		
    this.text = text;
		this.sumText = sumText;
		this.type = type;
		this.fileName = fileName;
		this.createDate = createDate;
	}
	
}
