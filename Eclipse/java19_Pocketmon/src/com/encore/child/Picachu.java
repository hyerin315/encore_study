package com.encore.child;

import com.encore.pocketmon.PocketMon;

public class Picachu extends PocketMon{//상속 목적으로 만들었기 때문에, 객체 생성 안함
	public Picachu() {
		System.out.println("피카츄 생성됨...");
		this.name = "Picachu";
		hp = 30;
	}
	
	@Override
	public void eat() {
		super.eat();//super과 this 모두 참조 변수
		hp += 5;
	}
	@Override
	public void sleep() {
		super.sleep();
		hp += 10;
	}
	@Override
	public boolean play() {
		super.play();
		hp -= 10;
		exp += 10;
		levelupCheck();
		return hp > 0;//비교 연산자 - 0보다 크면 true, 작으면 flase
	}
	@Override
	public boolean exc() {
		super.exc();
		hp -= 15;
		exp += 15;
		levelupCheck();
		return hp > 0;
	}
	@Override
	public void levelupCheck() {
		super.levelupCheck();
		if(exp>=30) {
			level++;
			exp -= 30;
			System.out.println(name + " 레벨이 1 증가하였습니다. ");
		}
	}
	
	public void pAttack() {
		System.out.println("백만볼트!!!!!!! 공격!");
	}
	
}
