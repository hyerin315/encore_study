package com.encore.service;

import java.util.Scanner;
import com.encore.child.Esanghaessi;
import com.encore.child.Picachu;
import com.encore.child.Raichu;
import com.encore.pocketmon.PocketMon;

public class Menu {
//  다형성을 모르는 케이스
/*	private Picachu p;
	private Esanghaessi e;
	private Raichu r;

	} */
	
	private PocketMon p;
	public void select(Scanner sc) {
		System.out.println("캐릭터 선택\n1.피카츄(기본) 2.이상해씨 3.라이츄");
		int x = sc.nextInt();
		if(x==2) {
			p = new Esanghaessi();
		}else if(x==3) {
			p = new Raichu();
		}else {
			p = new Picachu();
		}
	}
//      진정한 다형성을 위해서는 업케스팅과 다운캐스팅을 배워야함
/*      아래 방식으로 만들면 메뉴를 3번 생성해야함
		if(x==2) {
			e = new Esanghaessi();
		}else if(x==3) {
			r = new Raichu();
		}else {
			p = new Picachu();
		}
	} */
		
	public void run(Scanner sc) {
		boolean flag = true;
		int menu;
		while(flag) {
			System.out.println("1.밥먹기 2.잠자기 3.놀기 4.운동하기 5.상태확인 6.종료 7.공격");
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
					System.out.println("캐릭터 사망");
				}
				break;
			case 4:
				flag = p.exc();
				if(!flag) {
					System.out.println("캐릭터 사망");
				}
				break;
			case 5:
				p.printInfo();
				break;
			case 6:
				flag = false;
				break;
			case 7:
				if(p instanceof Picachu) {
					((Picachu)p).pAttack();
				}else if(p instanceof Raichu) {
					((Raichu)p).rAttack();
				}else if(p instanceof Esanghaessi) {
					((Esanghaessi)p).eAttack();
				}
			}
		}
		System.out.println("게임 종료");
	}
}

