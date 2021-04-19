package com.encore.child;

import com.encore.pocketmon.PocketMon;

public class Esanghaessi extends PocketMon{
	public Esanghaessi() {
		System.out.println("이상해씨 생성됨...");
		this.name = "Esanghaessi";
		hp = 10;
	}

	
	@Override
	public void eat() {
		super.eat();//super과 this 모두 참조 변수
		hp += 4;
	}
	@Override
	public void sleep() {
		super.sleep();
		hp += 11;
	}
	@Override
	public boolean play() {
		super.play();
		hp -= 12;
		exp += 13;
		levelupCheck();
		return hp > 0;//비교 연산자 - 0보다 크면 true, 작으면 flase
	}
	@Override
	public boolean exc() {
		super.exc();
		hp -= 17;
		exp += 19;
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
	public void eAttack() {
		System.out.println("넝쿨 공격!!!!!");
	}
}
