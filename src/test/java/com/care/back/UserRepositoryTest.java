package com.care.back;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.care.back.entity.UserRepository;
import com.care.back.member.service.MemberService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
//	@DisplayName("1. 유저 데이터 생성")
//	@Test
//	public void test() {
//		String encPassword = passwordEncoder.encode("test_password");
//		UserEntity userEntity = UserEntity.builder()
//				.id("test_user")
//				.pwd(encPassword)
//				.regdate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
//				.useyn("Y")
//				.nickname("테스트유저")
//				.build();
//		
//		UserEntity savedUser = userRepository.save(userEntity);
//		assertThat(userEntity.getId()).isEqualTo(savedUser.getId());
//	}
	
	@DisplayName("2. 유저정보 검색 후 비밀번호 비교")
	@Test
	public void test2() {
		/*
		 * String encPassword = passwordEncoder.encode("test_password");
		 * 
		 * UserEntity user = userRepository.findById("test_user") .orElseThrow(() -> new
		 * UsernameNotFoundException("사용자를 찾을 수 없습니다."));
		 * 
		 * assertThat(user.getPwd()).isEqualTo(encPassword);
		 */
		String id = "test_user";
		String pwd = "test_password";
		UserDetails user = memberService.loadUserByUsername(id);
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, pwd);
		authenticationManager.authenticate(authenticationToken);
		
		assertThat(authenticationToken.getCredentials()).isEqualTo(pwd);
		
		System.out.println("getCredentials: " + authenticationToken.getCredentials());
		System.out.println("pwd: " + pwd);
	}

}
