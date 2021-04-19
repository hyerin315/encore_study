package pocketmon;

import java.util.Scanner;

public class Menu {
//  다형성을 이해 못한 사람
//	private Picachu p;
//	private Gobook g;
//	private Lee l;
	
	private PocketMon p;
	
	public void select(Scanner sc) {
		System.out.println("1.꼬북이(기본) 2.이상해씨 3.피카츄");
		int x = sc.nextInt();
		if(x==2) {
			p = new Gobook();//�뾽 罹먯뒪�똿
		}else if(x==3) {
			p = new Lee();//�뾽 罹먯뒪�똿
		}else {
			p = new Picachu();//�뾽 罹먯뒪�똿
		}
	}
	public void run(Scanner sc) {
		boolean flag = true;
		int menu;
		while (flag) {
			System.out.println("1.먹기 2.잠 자기 3.놀기 4.운동하기 5.상태 확인하기 6.종료하기 7.공격");
			menu = sc.nextInt();
			switch(menu) {
			case 1: 
				p.eat();
				break;
			case 2:
				p.sleep();
				break;
			case 3:
				flag = p.play();
				if(!flag) {
					System.out.println("사망했습니다.");
				}
				break;
			case 4:
				flag = p.exc();
				if(!flag) {
					System.out.println("사망했습니다.");
				}
				break;
			case 5:
				p.printInfo();
				break;
			case 6:
				flag = false;
				break;
			case 7:
				if (p instanceof Picachu) {
					((Picachu)p).pAttack();
				}else if(p instanceof Gobook) {
					((Gobook)p).gAttack();
				}else if(p instanceof Lee) {
					((Lee)p).lAttack();
				}
			}
		}
		System.out.println("게임을 종료합니다.");
	}
}
