package com.care.back.knowledge.service;

import com.care.back.knowledge.dto.KnowledgeDto;
import com.care.back.qna.dto.QnaDto;

public interface BilKnowledgeService {

	public int knowledgeWriteProc(KnowledgeDto dto);
	public int knowledgeUpdateProc(KnowledgeDto dt);
	public int knowledgeDeleteProc(KnowledgeDto dt);
}
