package com.care.back.comment.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.care.back.comment.dto.BilCommentDto;

public interface BilCommentService {
	public int commentWriteProc(BilCommentDto dto);
	public int commentUpdateProc(BilCommentDto dto);
	public int commentDeleteProc(BilCommentDto dto);
	public ArrayList<BilCommentDto> getCommentList(BilCommentDto dto);
}
