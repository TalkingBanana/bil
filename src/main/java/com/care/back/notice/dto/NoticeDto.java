package com.care.back.notice.dto;

import lombok.Data;

@Data
public class NoticeDto {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String writeDate;
	private int heart;
	private int view;
}
