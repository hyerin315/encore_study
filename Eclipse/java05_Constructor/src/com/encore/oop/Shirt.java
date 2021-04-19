package com.encore.oop;
//Shirt�� ���� ������ ��� �ִ� Ŭ����
public class Shirt {
	//1. �ʵ� ����
	public String maker;
	public boolean longSleeved;
	public char color;
	public float price;//double�� ����� ������ �ȳ�
	
	//2. �� ����...����� ����
	public void setShirt(String maker, boolean longSleeved, char color, float price) {
		//�ʵ� �ʱ�ȭ == ���� ��� �ȿ� �ִ� ������ �ʵ� �ȿ� �ִ� ���� ������
		//�ʱ�ȭ��? �Ÿ𸮿� �⺻���� ���µ� ������ִ� ��
		this.maker=maker;
		this.longSleeved = longSleeved;
		this.color = color;
		this.price = price;	
	}
	
	//3. �� �޾ƿ�
	//������ Ÿ���� �ٸ��� ��� ��� String���� �޴���? 
	//String + No-String�� Contact --> Stringȭ �Ǿ�����.
	public String getShirt() {
		return maker+" "+longSleeved+","+color+","+price;//�ʵ� ���� String���� return�� (ȣ���� ������)
		//getShirt() calling
	}
	
	//3-1.
	public void printShirtInfo() {
		System.out.println(maker+" "+longSleeved+","+color+","+price);
	}

}
