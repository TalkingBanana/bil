package com.care.back.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.care.back.member.dto.MemberDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="member")
@Entity
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String id;
	private String pwd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	private String useyn;
	private String nickname;

	public UserEntity(MemberDto memberDto) {
		this.id = memberDto.getId();
		this.pwd = memberDto.getPwd();
		this.nickname = memberDto.getNickname();
	}
	
	  public static UserEntity registMember(MemberDto memberDto){
	        return new UserEntity(memberDto);
	    }
	
}
