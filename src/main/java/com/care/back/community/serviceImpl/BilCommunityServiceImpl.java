package com.care.back.community.serviceImpl;

import com.care.back.community.dto.CommunityDto;

public interface BilCommunityServiceImpl {

	public int communityWriteProc(CommunityDto dto);
	public int communityUpdateProc(CommunityDto dto);
	public int communityDeleteProc(CommunityDto dto);
}
