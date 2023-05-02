package com.care.back.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.back.member.dto.MemberDto;
import com.care.back.member.serviceImpl.BilMemberServiceImpl;

@Controller
public class BilMemberController {

	
	@Autowired
	BilMemberServiceImpl service;
	
	@RequestMapping("/login")
	@ResponseBody
	public String loginProc(@RequestBody MemberDto dto) {
		String result = "";
		
		
		return result;
	}
	
	@RequestMapping("/signin")
	@ResponseBody
	public String signinProc(@RequestBody MemberDto dto) {
		String result = "";
		
		return result;
	}
	
	@RequestMapping("/pwdUpdate")
	@ResponseBody
	public String pwdUpdateProc(@RequestBody MemberDto dto) {
		String result = "";
		
		return result;
	}
	
	@RequestMapping("/accountUpdate")
	@ResponseBody
	public String accountUpdate(@RequestBody MemberDto dto) {
		String result = "";
		
		return result;
	}
	
	@RequestMapping("/idChk")
	@ResponseBody
	public String idChk(@RequestBody String id) {
		String result = "";
		
		return result;
	}
}
