package com.care.back.editor.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface BilEditorService {
	public String imageUpload(MultipartHttpServletRequest request, HttpServletResponse res);
	public String fileUpload(MultipartHttpServletRequest request, HttpServletResponse res) throws IOException;
}
