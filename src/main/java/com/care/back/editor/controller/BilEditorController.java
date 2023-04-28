package com.care.back.editor.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.back.editor.serviceImpl.BilEditorServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/")
public class BilEditorController {
	
	@Autowired
	BilEditorServiceImpl service;
	
	
	@RequestMapping("/knowledgeUpload")
	@ResponseBody
	public HashMap<String, Object> uploadHandler(
			MultipartHttpServletRequest request, HttpServletResponse res
			) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("url", "https://biltd.org/images/home/header-bg.jpg");
		return map;
	}

}
