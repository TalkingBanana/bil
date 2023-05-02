package com.care.back.member.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.back.member.dao.BilMemberDao;
import com.care.back.member.dto.MemberDto;
import com.care.back.member.service.BilMemberService;

@Service
public class BilMemberServiceImpl implements BilMemberService{

	@Autowired
	BilMemberDao dao;

	@Override
	public int signin(MemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int idChk(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int loginProc(MemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int freedom(MemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pwdChange(MemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nicknameChange(MemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
