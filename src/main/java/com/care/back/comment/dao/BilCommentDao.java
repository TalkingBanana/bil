package com.care.back.comment.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.care.back.comment.dto.BilCommentDto;

@Mapper
public interface BilCommentDao {
	public ArrayList<BilCommentDto> getCommentList(BilCommentDto dto);
}
