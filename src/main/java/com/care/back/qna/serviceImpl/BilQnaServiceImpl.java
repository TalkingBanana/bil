package com.care.back.qna.serviceImpl;

import com.care.back.qna.dto.QnaDto;

public interface BilQnaServiceImpl {

	public int qnaWriteProc(QnaDto dto);
	public int qnaUpdateProc(QnaDto dto);
	public int qnaDeleteProc(QnaDto dto);
}
