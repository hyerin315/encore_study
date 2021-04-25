package com.example.validator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController {
	public CalcController() {
		//서버에서 검증하는 부분
		System.out.println("-----> CalcController created");
	}
	
	@GetMapping("/calc")
	public String calc() {
		return "/calc/form";
	}
	
	@PostMapping("/calc")
	public String calc(CalcVOAnnotation vo, BindingResult result, Model model) {
		CalcValidator validator = new CalcValidator();
		validator.validate(vo, result);//검증
		
		if(result.hasErrors()) {
			return "/calc/form";
		}else {
			int payment = vo.getPrice() * vo.getCount();
			//model = request에 저장했다는 것
			model.addAttribute("payment", payment);
			
			return "/calc/proc";
		}
	}
}
