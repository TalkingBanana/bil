package com.care.back.qna.service;

import com.care.back.qna.dto.QnaDto;

public interface BilQnaService {

	public int qnaWriteProc(QnaDto dto);
	public int qnaUpdateProc(QnaDto dto);
	public int qnaDeleteProc(QnaDto dto);
}
