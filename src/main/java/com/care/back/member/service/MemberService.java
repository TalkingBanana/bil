package com.care.back.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.care.back.entity.UserEntity;
import com.care.back.entity.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		UserEntity userEntity = userRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
		
		if (userEntity.getId().equals(username)) {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		return new User(userEntity.getId(), userEntity.getPwd(),authorities);
	}
	
	
	public boolean isDuplicatedId(String id) {
	     Optional<UserEntity> userEntity = userRepository.findById(id);
	     return userEntity.isPresent();
	}

	public boolean isDuplicatedNickname(String nickname) {
	     Optional<UserEntity> userEntity = userRepository.findByNickname(nickname);
	     return userEntity.isPresent();
	}
	

}
