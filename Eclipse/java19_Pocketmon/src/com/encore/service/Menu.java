package com.encore.service;

import java.util.Scanner;
import com.encore.child.Esanghaessi;
import com.encore.child.Picachu;
import com.encore.child.Raichu;
import com.encore.pocketmon.PocketMon;

public class Menu {
//  �������� �𸣴� ���̽�
/*	private Picachu p;
	private Esanghaessi e;
	private Raichu r;

	} */
	
	private PocketMon p;
	public void select(Scanner sc) {
		System.out.println("ĳ���� ����\n1.��ī��(�⺻) 2.�̻��ؾ� 3.������");
		int x = sc.nextInt();
		if(x==2) {
			p = new Esanghaessi();
		}else if(x==3) {
			p = new Raichu();
		}else {
			p = new Picachu();
		}
	}
//      ������ �������� ���ؼ��� ���ɽ��ð� �ٿ�ĳ������ �������
/*      �Ʒ� ������� ����� �޴��� 3�� �����ؾ���
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
			System.out.println("1.��Ա� 2.���ڱ� 3.��� 4.��ϱ� 5.����Ȯ�� 6.���� 7.����");
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
					System.out.println("ĳ���� ���");
				}
				break;
			case 4:
				flag = p.exc();
				if(!flag) {
					System.out.println("ĳ���� ���");
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
		System.out.println("���� ����");
	}
}

