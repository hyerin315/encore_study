package com.example.validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class CalcVOAnnotation {
	//검증을 annotation에서 하는 방법
	@NotEmpty(message="메뉴명은 필수 입력입니다.(Not Empty)")
	@Size(min=2, max=30, message="메뉴명은 2자 이상 30자 미만입니다")
	private String menu;
	@Max(value=1000000, message="금액은 100만원 이하여야합니다")
	@Min(value=1000, message="금액은 1000원 이상이어야 합니다")
	private int price;
	@Max(value=100, message="수량은 100개 이하여야합니다")
	@Min(value=1, message="수량은 1개 이상이어야 합니다")
	private int count;
	private int payment;
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "CalcVO [menu=" + menu + ", price=" + price + ", count=" + count + ", payment=" + payment + "]";
	}
}
