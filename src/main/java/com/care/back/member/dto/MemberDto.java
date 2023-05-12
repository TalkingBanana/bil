package com.care.back.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

	private String id;
	private String pwd;
	private String nickname;
	
	public MemberDto(String id, String pwd, String nickname) {

		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
	}
	
	
}
