package com.care.back;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.care.back.util.JwtUtil;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JwtUtilTest {

	@Autowired
	JwtUtil jwtUtil;
	
	@DisplayName("1. 토큰 생성 후 검증")
	@Test
	public void test() {
		String id = "user1";
		String nickName = "사용자1";
		
		String token = jwtUtil.createToken(id, nickName);
		
		System.out.println("Token: " + token); 
		
		assertThat(jwtUtil.decodeToken(token).getClaim("nickName").asString()).isEqualTo(nickName);
	}
}
