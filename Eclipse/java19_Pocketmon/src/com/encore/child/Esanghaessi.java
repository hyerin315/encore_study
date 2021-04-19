package com.encore.child;

import com.encore.pocketmon.PocketMon;

public class Esanghaessi extends PocketMon{
	public Esanghaessi() {
		System.out.println("�̻��ؾ� ������...");
		this.name = "Esanghaessi";
		hp = 10;
	}

	
	@Override
	public void eat() {
		super.eat();//super�� this ��� ���� ����
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
		return hp > 0;//�� ������ - 0���� ũ�� true, ������ flase
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
			System.out.println(name + " ������ 1 �����Ͽ����ϴ�. ");
		}
	}
	public void eAttack() {
		System.out.println("���� ����!!!!!");
	}
}
