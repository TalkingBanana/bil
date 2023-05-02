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
	public ArrayList<BilStudyDto> boardList(int page){
		ArrayList<BilStudyDto> list = new ArrayList<>();
		System.out.println("page : " + page);
		list = service.studyList();
		return list;
	}
}
