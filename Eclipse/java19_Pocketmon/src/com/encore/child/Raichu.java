package com.encore.child;

import com.encore.pocketmon.PocketMon;

public class Raichu extends PocketMon{
	public Raichu() {
		System.out.println("라이츄 생성됨...");
		this.name = "Raichu";
		hp = 20;
	}

	
	@Override
	public void eat() {
		super.eat();//super과 this 모두 참조 변수
		hp += 6;
	}
	@Override
	public void sleep() {
		super.sleep();
		hp += 9;
	}
	@Override
	public boolean play() {
		super.play();
		hp -= 7;
		exp += 8;
		levelupCheck();
		return hp > 0;//비교 연산자 - 0보다 크면 true, 작으면 flase
	}
	@Override
	public boolean exc() {
		super.exc();
		hp -= 6;
		exp += 7;
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
	public void rAttack() {
		System.out.println("십만 볼트!!!!!!! 공격!");
	}
}
