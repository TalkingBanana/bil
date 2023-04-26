package com.care.back.member.dto;

import lombok.Data;

@Data
public class MemberDto {
	private String id;
	private String pwd;
	private String name;
	private String regDate;
	private String useYn;
	private String nickname;

}
