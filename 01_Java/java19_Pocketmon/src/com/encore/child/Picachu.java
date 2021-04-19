package com.encore.child;

import com.encore.pocketmon.PocketMon;

public class Picachu extends PocketMon{//��� �������� ������� ������, ��ü ���� ����
	public Picachu() {
		System.out.println("��ī�� ������...");
		this.name = "Picachu";
		hp = 30;
	}
	
	@Override
	public void eat() {
		super.eat();//super�� this ��� ���� ����
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
		return hp > 0;//�� ������ - 0���� ũ�� true, ������ flase
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
			System.out.println(name + " ������ 1 �����Ͽ����ϴ�. ");
		}
	}
	
	public void pAttack() {
		System.out.println("�鸸��Ʈ!!!!!!! ����!");
	}
	
}
