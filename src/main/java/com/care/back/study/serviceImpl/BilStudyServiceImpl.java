package com.care.back.study.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.back.study.dao.BilStudyDao;
import com.care.back.study.dto.BilStudyDto;
import com.care.back.study.service.BilStudyService;


@Service
public class BilStudyServiceImpl implements BilStudyService{

	
	@Autowired
	BilStudyDao dao;
	
	@Override
	public ArrayList<BilStudyDto> studyList() {
		// TODO Auto-generated method stub
		ArrayList<BilStudyDto> list = dao.getStudyList();
		return list;
	}

	@Override
	public int deleteStudy(BilStudyDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudy(BilStudyDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertStudy(BilStudyDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
