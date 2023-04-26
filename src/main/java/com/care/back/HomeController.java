package com.care.back;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("안녕하세요!");
		HashMap<String, Object> map = new HashMap<>();
		return "안녕하세요!";
	}
}
