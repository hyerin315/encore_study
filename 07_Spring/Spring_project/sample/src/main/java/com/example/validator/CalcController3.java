package com.example.validator;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController3 {
	public CalcController3() {
		System.out.println("-------> CalcController3 created");
	}

	@GetMapping("/calc3")
	public String calc() {
		return "/calc/form3";
	}
	
	@PostMapping("/calc3")
	public String calc(@Valid CalcVOAnnotation calcVO, BindingResult result, Model model) {//BindingResult : 에러났는지 확인해주는 값
		Map<String, String> errors = new HashMap <String, String>();
		
		if(result.hasErrors()) {//에러가 있을 때의 if문
			if(result.getFieldError("menu") != null) {
				System.out.println("menu:" + result.getFieldError("menu").getDefaultMessage());
				errors.put("menu", "menu 등록이 누락되었습니다");
			}
			if(result.getFieldError("price") != null) {
				System.out.println("price:" + result.getFieldError("price").getDefaultMessage());
				errors.put("price", "금액이 1000원 이상 백만원 이하여야 합니다");
			}
			if(result.getFieldError("count") != null) {
				System.out.println("count:" + result.getFieldError("count").getDefaultMessage());
				errors.put("count", "수량은 1개 이상 100개 이하여야 합니다");
			}
			
			model.addAllAttributes(errors);
			return "/calc/form3";
		}else {
			int payment = calcVO.getPrice() * calcVO.getCount();
			model.addAttribute("payment",payment);
			return "/calc/proc";
		}
	}
}
