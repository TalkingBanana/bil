package com.care.back.study.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.care.back.comment.dto.BilCommentDto;
import com.care.back.study.dto.BilStudyDto;
import com.care.back.study.service.BilStudyService;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api")
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
			@RequestParam("contents") String contents,
			@RequestParam("category") String category,
			@RequestParam(required = false, value="file") MultipartFile file
			) {
		BilStudyDto dto = new BilStudyDto();
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setCategory(category);
		int result = service.insertStudy(dto, file);
		return result;
	}
	
	@RequestMapping("/studyDetail")
	public BilStudyDto studyDetail(@RequestParam("num") int num) {
		BilStudyDto dto = new BilStudyDto();
		dto = service.getStudyDetail(num);
		return dto;
	}
	
	@RequestMapping("/fileDownload")
	public void fileDownload(String path, HttpServletResponse res){
		service.fileDownload(res, path);
	}
	
}
