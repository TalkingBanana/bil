package com.care.back.member.service;

import com.care.back.member.dto.MemberDto;

public interface BilMemberService {

	public int signin(MemberDto dto);
	public int idChk(String id);
	public int loginProc(MemberDto dto);
	public int freedom(MemberDto dto);
	public int pwdChange(MemberDto dto);
	public int nicknameChange(MemberDto dto);
}
