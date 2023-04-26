package com.care.back.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.care.back.member.dto.MemberDto;

@Mapper
public interface BilMemberDao {
	public int idChk(MemberDto dto);
	public void signin(MemberDto dto);
}
