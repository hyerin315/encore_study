package com.example.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController2 {
	public CalcController2() {
		//서버에서 검증하는 부분
		System.out.println("-----> CalcController2 created");
	}
	
	@GetMapping("/calc2")
	public String calc() {
		return "/calc/form2";
	}
	
	@PostMapping("/calc2")
	public String calc(CalcVOAnnotation vo, BindingResult result, Model model) {
		CalcValidator validator = new CalcValidator();
		validator.validate(vo, result);//검증
		Map<String, String> errors = new HashMap<String, String>();
		
		if(result.hasErrors()) {
			//메뉴라는 이름에 필드의 에러가 있다면
			if(result.getFieldError("menu")!=null) {
				System.out.println("menu:" + result.getFieldError("menu").getCode());
				errors.put("menu", "menu 등록이 누락되었습니다");//폼에 보여질 값을 Map에 저장
			}
			if(result.getFieldError("price")!=null) {
				System.out.println("price:" + result.getFieldError("price").getCode());
				errors.put("price", "금액은 1000원 이상 천만원 이하여야 합니다.");
			}
			if(result.getFieldError("count")!=null) {
				System.out.println("count:" + result.getFieldError("count").getCode());
				errors.put("count", "수량은 1개 이상 천 개 이하여야합니다");
			}
			model.addAllAttributes(errors);
			return "/calc/form2";//오류가 발생되면 (출력할 메세지를 가지고) form2로 되돌아감
		}else {
			int payment = vo.getPrice() * vo.getCount();
			//model = request에 저장했다는 것
			model.addAttribute("payment", payment);
			
			return "/calc/proc";
		}
	}
}
