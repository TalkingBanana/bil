package com.care.back.study.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.care.back.study.dto.BilStudyDto;
import com.care.back.study.service.BilStudyService;

@RestController
@RequestMapping("/api/")
public class BilStudyController {
	
	@Autowired
	BilStudyService service;
	
	
	@RequestMapping("/studyList")
	public ArrayList<BilStudyDto> boardList(int page, String category, String keyword, String order){
		ArrayList<BilStudyDto> list = new ArrayList<>();
		list = service.studyList(page, category, keyword, order);
		return list;
	}
	
	@RequestMapping("/studyTotal")
	public int studyTotal(String category, String keyword) {
		int result = service.getStudyTotal(category, keyword);
		return result;
	}
	
	@RequestMapping("/insertStudy")
	public int insertStudy(
			@RequestParam("title") String title, 
			@RequestParam("category") String category, 
			@RequestParam("contents") String contents) {
		BilStudyDto dto = new BilStudyDto();
		dto.setTitle(title); dto.setCategory(category); dto.setContents(contents);
		int result = service.insertStudy(dto);
		return result;
	}
	
	@RequestMapping("/studyDetail")
	public BilStudyDto studyDetail(@RequestParam("num") int num) {
		BilStudyDto dto = new BilStudyDto();
		dto = service.getStudyDetail(num);
		return dto;
	}
}
