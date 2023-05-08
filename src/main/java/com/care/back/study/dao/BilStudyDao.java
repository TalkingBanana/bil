package com.care.back.study.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.care.back.study.dto.BilStudyDto;

@Mapper
public interface BilStudyDao {

	public ArrayList<BilStudyDto> getStudyList();
	public int getStudyTotal();
	public int deleteStudy(BilStudyDto dto);
	public int updateStudy(BilStudyDto dto);
	public int insertStudy(BilStudyDto dto);
}
