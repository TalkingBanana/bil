package com.care.back.comment.dto;

import lombok.Data;

@Data
public class CommentDto {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String writeDate;
	private int heart;
	private int view;
}
