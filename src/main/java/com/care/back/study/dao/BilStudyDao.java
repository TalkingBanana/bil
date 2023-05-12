package com.care.back.study.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.care.back.study.dto.BilStudyDto;

@Mapper
public interface BilStudyDao {

	public ArrayList<BilStudyDto> getStudyList(HashMap<String, Object> map);
	public int getStudyTotal(HashMap<String,Object> map);
	public BilStudyDto getStudyDetail(int num);
	public int deleteStudy(BilStudyDto dto);
	public int updateStudy(BilStudyDto dto);
	public int insertStudy(BilStudyDto dto);
	public int increaseView(int num);
}
