package com.encore.pocketmon;
//��� �������� ����
//�θ� Ŭ����
public class PocketMon {//��ü ���� ����
	protected String name;
	protected int hp;
	protected int exp;
	protected int level;
	
	public void eat() {
		System.out.println(name + ", �� �Դ� ��...");
	}
	
	public void sleep() {
		System.out.println(name + ", �� �ڴ� ��...");
	}

	public boolean play() {//boolean�� �ϴ� ������ �׾����� ��Ҵ��� Ȯ���ϱ� ����
		System.out.println(name + ", ��� ��...");
		return true;
	}
	
	public boolean exc() {//boolean�� �ϴ� ������ �׾����� ��Ҵ��� Ȯ���ϱ� ����
		System.out.println(name + ", � ��...");
		return true;
	}
	public void levelupCheck() {
		System.out.println(name + ", ���� �� üũ...");
	}
	public void printInfo() {
		System.out.println(name + ", ���� Ȯ��");
		System.out.println("hp: " + hp);
		System.out.println("exp: " + exp);
		System.out.println("level: " +level);
	}
}
