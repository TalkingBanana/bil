package com.care.back.qna.dto;

import lombok.Data;

@Data
public class QnaDto {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String writeDate;
	private int heart;
	private int view;
}
