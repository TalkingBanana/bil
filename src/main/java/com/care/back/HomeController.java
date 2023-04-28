package com.care.back;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
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
		return "안녕하세요!";
	}
}
