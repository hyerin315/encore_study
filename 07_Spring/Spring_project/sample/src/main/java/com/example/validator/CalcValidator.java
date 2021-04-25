package com.example.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CalcValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {//Class가 가질 수 있는 타입이 바뀔 수 있기 때문에, 확정짓지 않고 선언시 확정되어져서 타입이 적용됨
		// 검증할 객체의 클래스 타입 정보 명시
		return CalcVOAnnotation.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CalcVOAnnotation calcVO = (CalcVOAnnotation)target;
		//controller까지 이동한 것 중에 getMenu를 꺼내오는 것
		String menu = calcVO.getMenu();
		if(menu == null || menu.trim().isEmpty()) {
			System.out.println("menu 등록이 누락되었습니다");
			//에러가 있을 경우
			errors.rejectValue("menu", "error");//임의의 값 지정, 에러 발생을 나타냄
		}
		
		int price = calcVO.getPrice();
		if(price < 1000 || price >= 10000000) {
			System.out.println("금액은 1000원 이상 천 만원 이하여야 합니다");
			errors.rejectValue("price", "error");
		}
		
		int count = calcVO.getCount();
		if(count <= 0 || count >= 1000) {
			System.out.println("수량은 1개 이상 천 개 이하여야 합니다");
			errors.rejectValue("count", "error");
		}
	}

	private void alret(String string) {
		// TODO Auto-generated method stub
		
	}

}
