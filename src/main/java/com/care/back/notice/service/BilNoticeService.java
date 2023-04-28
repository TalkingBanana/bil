package com.care.back.notice.service;

import com.care.back.notice.dto.NoticeDto;

public interface BilNoticeService {

	public int noticeWriteProc(NoticeDto dto);
	public int noticeUpdateProc(NoticeDto dto);
	public int noticeDeleteProc(NoticeDto dto);
}
