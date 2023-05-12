package com.care.back.comment.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care.back.comment.dto.BilCommentDto;
import com.care.back.comment.serviceImpl.BilCommentSerivceImpl;

@RestController
@RequestMapping("/api")
public class BilCommentController {


	@Autowired
	private BilCommentSerivceImpl service;
	
	@RequestMapping("/getCommentList")
	public ArrayList<BilCommentDto> getCommentList(int num, String category){
		ArrayList<BilCommentDto> result = new ArrayList<>();
		BilCommentDto dto = new BilCommentDto();
		dto.setNum(num); dto.setCategory(category);
		result = service.getCommentList(dto);
		
		return result;
		
	}
}
