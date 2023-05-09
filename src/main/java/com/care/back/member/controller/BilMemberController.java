package com.care.back.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care.back.member.service.MemberService;
import com.care.back.util.JwtUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/user")
public class BilMemberController {
	private final JwtUtil jwtUtil;
	private final MemberService memberService;
	private final AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> paramMap) {
		String id = paramMap.get("id");
		String pwd = paramMap.get("pwd");
		
		UserDetails loginUser = memberService.loadUserByUsername(id); //id로 정보 가져오기
		
		Authentication authentication = authenticationManager.authenticate( //가져온 정보와 입력한 비밀번호로 검증
					new UsernamePasswordAuthenticationToken(loginUser, pwd));
		
		SecurityContextHolder.getContext().setAuthentication(authentication); // 검증 통과 후 authentication 세팅
		
		String accessToken = jwtUtil.createToken(loginUser.getUsername(), loginUser.getUsername());  //accessToken 생성
		
		Map<String, Object> result = new HashMap<>();
		result.put("id", loginUser.getUsername());
		result.put("user_token", accessToken);
		result.put("user_role", loginUser.getAuthorities().stream().findFirst().get().getAuthority());
		
		return ResponseEntity.ok(result);
	}
	
}
