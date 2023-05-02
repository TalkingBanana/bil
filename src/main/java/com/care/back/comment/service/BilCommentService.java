package com.care.back.comment.service;

import com.care.back.comment.dto.CommentDto;

public interface BilCommentService {
	public int commentWriteProc(CommentDto dto);
	public int commentUpdateProc(CommentDto dto);
	public int commentDeleteProc(CommentDto dto);
}
