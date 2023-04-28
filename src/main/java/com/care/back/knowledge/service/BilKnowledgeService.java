package com.care.back.knowledge.serviceImpl;

import com.care.back.knowledge.dto.KnowledgeDto;
import com.care.back.qna.dto.QnaDto;

public interface BilKnowledgeServiceImpl {

	public int knowledgeWriteProc(KnowledgeDto dto);
	public int knowledgeUpdateProc(KnowledgeDto dt);
	public int knowledgeDeleteProc(KnowledgeDto dt);
}
