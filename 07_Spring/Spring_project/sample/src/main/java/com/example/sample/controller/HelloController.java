package com.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping
	@ResponseBody
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/test")
	public String test() {
		//찾는 경로에 대한 내용은 application.properties에 있음
		return "test";
	}
}
