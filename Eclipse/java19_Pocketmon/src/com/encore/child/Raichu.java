package com.encore.child;

import com.encore.pocketmon.PocketMon;

public class Raichu extends PocketMon{
	public Raichu() {
		System.out.println("������ ������...");
		this.name = "Raichu";
		hp = 20;
	}

	
	@Override
	public void eat() {
		super.eat();//super�� this ��� ���� ����
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
		return hp > 0;//�� ������ - 0���� ũ�� true, ������ flase
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
			System.out.println(name + " ������ 1 �����Ͽ����ϴ�. ");
		}
	}
	public void rAttack() {
		System.out.println("�ʸ� ��Ʈ!!!!!!! ����!");
	}
}
