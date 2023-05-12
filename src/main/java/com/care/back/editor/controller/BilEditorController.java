package com.care.back.editor.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.back.editor.serviceImpl.BilEditorServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/")
public class BilEditorController {
	
	@Autowired
	BilEditorServiceImpl service;
	
	
	@RequestMapping("/studyUpload")
	public HashMap<String, Object> uploadHandler(
			MultipartHttpServletRequest req, HttpServletResponse res
			) throws IOException {
		String result = service.imageUpload(req, res);
		System.out.println("??");
		HashMap<String, Object> map = new HashMap<>();
		map.put("url", "http://localhost:8080/IMAGE/"+result);
		return map;
	}
}
