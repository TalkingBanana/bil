package com.care.back.community.dto;

import lombok.Data;

@Data
public class CommunityDto {
	private int num;
	private String writer;
	private String contents;
	private String writeDate;
	private int heart;
	private int parentId;
	private int postId;
	private String category;
}
