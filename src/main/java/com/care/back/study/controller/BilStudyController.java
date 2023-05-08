package com.care.back.study.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.back.study.dto.BilStudyDto;
import com.care.back.study.service.BilStudyService;

@Controller
@RequestMapping("/api/")
public class BilStudyController {
	
	@Autowired
	BilStudyService service;
	
	
	@RequestMapping("/studyList")
	@ResponseBody
	public ArrayList<BilStudyDto> boardList(int page, String category, String keyword, String order){
		ArrayList<BilStudyDto> list = new ArrayList<>();
		list = service.studyList(page, category, keyword, order);
		return list;
	}
	
	@RequestMapping("/studyTotal")
	@ResponseBody
	public int studyTotal(String category, String keyword) {
		int result = service.getStudyTotal(category, keyword);
		return result;
	}
	
	@RequestMapping("/insertStudy")
	@ResponseBody
	public int insertStudy() {
		BilStudyDto dto = new BilStudyDto();
		int result = service.insertStudy(dto);
		return result;
	}
}
