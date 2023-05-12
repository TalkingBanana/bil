package com.care.back.study.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.care.back.comment.dto.BilCommentDto;
import com.care.back.study.dto.BilStudyDto;

import jakarta.servlet.http.HttpServletResponse;


public interface BilStudyService {

	public ArrayList<BilStudyDto> studyList(int currentPage, String category, String keyword, String order);
	public int getStudyTotal(String category, String keyword);
	public BilStudyDto getStudyDetail(int num);
	public int deleteStudy(BilStudyDto dto);
	public int updateStudy(BilStudyDto dto);
	public int insertStudy(BilStudyDto dto, MultipartFile file);
	public void fileDownload(HttpServletResponse res, String path);
}
