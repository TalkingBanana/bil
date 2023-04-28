package com.care.back.comment.serviceImpl;

import com.care.back.comment.dto.CommentDto;

public interface BilCommentServiceImpl {
	public int commentWriteProc(CommentDto dto);
	public int commentUpdateProc(CommentDto dto);
	public int commentDeleteProc(CommentDto dto);
}
