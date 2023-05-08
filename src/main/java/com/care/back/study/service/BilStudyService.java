package com.care.back.study.service;

import java.util.ArrayList;


import com.care.back.study.dto.BilStudyDto;

public interface BilStudyService {

	public ArrayList<BilStudyDto> studyList(int currentPage, String category, String keyword, String order);
	public int getStudyTotal(String category, String keyword);
	public int deleteStudy(BilStudyDto dto);
	public int updateStudy(BilStudyDto dto);
	public int insertStudy(BilStudyDto dto);
}
