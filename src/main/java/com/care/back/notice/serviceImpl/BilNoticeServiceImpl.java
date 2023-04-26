package com.care.back.notice.serviceImpl;

import com.care.back.notice.dto.NoticeDto;

public interface BilNoticeServiceImpl {

	public int noticeWriteProc(NoticeDto dto);
	public int noticeUpdateProc(NoticeDto dto);
	public int noticeDeleteProc(NoticeDto dto);
}
