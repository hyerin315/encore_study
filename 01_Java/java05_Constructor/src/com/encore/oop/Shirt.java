package com.encore.oop;
//Shirt에 대한 정보를 담고 있는 클래스
public class Shirt {
	//1. 필드 선언
	public String maker;
	public boolean longSleeved;
	public char color;
	public float price;//double로 만들면 오류가 안남
	
	//2. 값 주입...기능을 정의
	public void setShirt(String maker, boolean longSleeved, char color, float price) {
		//필드 초기화 == 셔츠 모듈 안에 있는 각각의 필드 안에 있는 값을 주입함
		//초기화란? 매모리에 기본값이 들어가는데 덮어씌워주는 것
		this.maker=maker;
		this.longSleeved = longSleeved;
		this.color = color;
		this.price = price;	
	}
	
	//3. 값 받아옴
	//데이터 타입이 다른데 어떻게 모두 String으로 받는지? 
	//String + No-String이 Contact --> String화 되어진다.
	public String getShirt() {
		return maker+" "+longSleeved+","+color+","+price;//필드 값을 String으로 return됨 (호출한 곳으로)
		//getShirt() calling
	}
	
	//3-1.
	public void printShirtInfo() {
		System.out.println(maker+" "+longSleeved+","+color+","+price);
	}

}
