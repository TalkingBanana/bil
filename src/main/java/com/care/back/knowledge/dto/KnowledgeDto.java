package com.care.back.knowledge.dto;

import lombok.Data;

@Data
public class KnowledgeDto {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String writeDate;
	private int heart;
	private int view;
}
