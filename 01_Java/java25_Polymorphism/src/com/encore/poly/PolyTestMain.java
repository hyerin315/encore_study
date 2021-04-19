package com.encore.poly;

class Product{
		String name;
		int price;
		int point;
}

class Tv extends Product{
	public Tv() {
		name = "tv";
		price = 1000;
		point = 100;
	}
}

class Audio extends Product{
	public Audio() {
		name = "audio";
		price = 2000;
		point = 200;
	}
}

class Computer extends Product{
	public Computer() {
		name = "computer";
		price = 3000;
		point = 300;
	}
}

class Buyer{
	int money = 10000;
	int point = 0;
	
	//�޼ҵ� �����ε�
	void buy(Tv tv) {
		if(money >= tv.price) {
			money -= tv.price;
			point += tv.point;
			System.out.println(tv.name+" ����");
			System.out.println("money : "+money+" / point : "+point);
		}else {
			System.out.println("�ܾ׺���");
		}
	}
	
	void buy(Audio audio) {
		if(money >= audio.price) {
			money -= audio.price;
			point += audio.point;
			System.out.println(audio.name+" ����");
			System.out.println("money : "+money+" / point : "+point);
		}else {
			System.out.println("�ܾ׺���");
		}
	}
	
	void buy(Computer computer) {
		if(money >= computer.price) {
			money -= computer.price;
			point += computer.point;
			System.out.println(computer.name+" ����");
			System.out.println("money : "+money+" / point : "+point);
		}else {
			System.out.println("�ܾ׺���");
		}
	}
}
class Buyer2{
	int money = 10000;
	int point = 0;
	
	void buy(Product a) {
		if(money >= a.price) {
			money -= a.price;
			point += a.point;
			System.out.println(a.name+" ����");
			System.out.println("money : "+money+" / point : "+point);
		}else {
			System.out.println("�ܾ׺���");
		}
	}
}

public class PolyTestMain {

	public static void main(String[] args) {
		//��ĳ����
		Product[] p = {new Tv(), new Audio(), new Computer(), new Tv(), new Audio(), new Computer(), new Tv(), new Audio(), new Computer()};
		Buyer2 b = new Buyer2();
		for(Product x : p) {
			b.buy(x);
		}
	}
}
