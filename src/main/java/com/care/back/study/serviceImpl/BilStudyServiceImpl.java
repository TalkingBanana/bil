package com.care.back.study.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

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
	public ArrayList<BilStudyDto> studyList(int currentPage, String category, String keyword, String order) {
		// TODO Auto-generated method stub
		String code = "";
		if(category.equals("자료실")) {
			code = "files";
		} else if (category.equals("강의")) {
			code = "video";
		} else {
			code = "";
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("page", (currentPage-1)*10);
		map.put("code", code);
		map.put("keyword", keyword);
		map.put("order", order);
		ArrayList<BilStudyDto> list = dao.getStudyList(map);
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
		if(dto.getCategory().equals("files")) {
			dto.setKorCategory("자료실");
		} else {
			dto.setKorCategory("강의");
		}
		dto.setWriter("테스터 계정");
		int result = dao.insertStudy(dto);
		return result;
	}

	@Override
	public int getStudyTotal(String category, String keyword) {
		// TODO Auto-generated method stub
		if(keyword == null) keyword="";
		String cateCode = "";
		if(category.equals("자료실")) {
			cateCode = "datas";
		} else if (category.equals("강의")) {
			cateCode = "video";
		} else {
			cateCode = "";
		};
		
		String keyCode = "";
		if(keyword.equals("최신순")) {
			keyCode = "";
		} else if(keyword.equals("추천순")) {
			
		} else if(keyword.equals("댓글순")) {
			
		} else if(keyword.equals("조회순")) {
			
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("code", cateCode);
		map.put("keyword", keyword);
		int result = dao.getStudyTotal(map);
		return result;
	}

	@Override
	public BilStudyDto getStudyDetail(int num) {
		// TODO Auto-generated method stub
		BilStudyDto dto = new BilStudyDto();
		dto = dao.getStudyDetail(num);
		return dto;
	}
}
