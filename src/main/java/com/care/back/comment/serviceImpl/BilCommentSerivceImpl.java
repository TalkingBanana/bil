package com.care.back.comment.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.back.comment.dao.BilCommentDao;
import com.care.back.comment.dto.BilCommentDto;
import com.care.back.comment.service.BilCommentService;

@Service
public class BilCommentSerivceImpl implements BilCommentService{

	@Autowired
	private BilCommentDao dao;
	
	
	
	@Override
	public int commentWriteProc(BilCommentDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentUpdateProc(BilCommentDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentDeleteProc(BilCommentDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BilCommentDto> getCommentList(BilCommentDto dto) {
		// TODO Auto-generated method stub
		ArrayList<BilCommentDto> result = new ArrayList<>();
		result = dao.getCommentList(dto);
		
		return result;
	}

}
