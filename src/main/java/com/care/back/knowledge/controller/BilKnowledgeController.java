package com.care.back.knowledge.controller;

import java.util.HashMap;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BilKnowledgeController {
	
	@RequestMapping("/knowledgeUpload")
	@ResponseBody
	public HashMap<String, Object> uploadHandler(HttpServletResponse response,@RequestPart(value = "image", required = false) MultipartFile image) {
		System.out.println(image);
		System.out.println(response.getContentType());
		HashMap<String, Object> map = new HashMap<>();
		map.put("url", "https://biltd.org/images/home/header-bg.jpg");
		return map;
	}
}