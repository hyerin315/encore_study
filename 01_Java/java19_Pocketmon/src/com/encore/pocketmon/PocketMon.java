package com.encore.pocketmon;
//상속 목적으로 생성
//부모 클래스
public class PocketMon {//객체 생성 안함
	protected String name;
	protected int hp;
	protected int exp;
	protected int level;
	
	public void eat() {
		System.out.println(name + ", 밥 먹는 중...");
	}
	
	public void sleep() {
		System.out.println(name + ", 잠 자는 중...");
	}

	public boolean play() {//boolean을 하는 이유는 죽었는지 살았는지 확인하기 위해
		System.out.println(name + ", 노는 중...");
		return true;
	}
	
	public boolean exc() {//boolean을 하는 이유는 죽었는지 살았는지 확인하기 위해
		System.out.println(name + ", 운동 중...");
		return true;
	}
	public void levelupCheck() {
		System.out.println(name + ", 레벨 업 체크...");
	}
	public void printInfo() {
		System.out.println(name + ", 상태 확인");
		System.out.println("hp: " + hp);
		System.out.println("exp: " + exp);
		System.out.println("level: " +level);
	}
}
