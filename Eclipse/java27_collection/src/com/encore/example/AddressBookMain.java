package com.encore.example;

import java.util.ArrayList;

class Member{
	String name;
	String tel;
	String address;
	
	public Member(String name, String tel, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}

	@Override
	public boolean equals(Object obj) {
		//�̸��� ������ ���� ��ü
		if(obj != null && obj instanceof Member) {
			Member m = (Member) obj;
			if(name == m.name) {
				return true;
			}
		}
		return false;
	}
	
}


public class AddressBookMain {

	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<>();
		list.add(new Member("aaa", "111", "���ѹα�"));
		list.add(new Member("bbb", "222", "���ʱ�"));
		list.add(new Member("ccc", "333", "���ﵿ"));
		
		//�̸��� bbb�� ����� �˻�
		//if(list.contains(new Member("bbb","222","���ʱ�"))) {//contains�� equals()�� �� (�����Ǹ� �����ָ� ���������θ� ã��)
		//x.equals(new Member("bbb",",",",")): Member�� equals()�� ȣ��
		
		//��� 1)
		Member x = new Member("bbb",",",",");//��� ��ü�� �������� ��� 2���� ������� ������ �ƴ��� Ȯ���� �� ����
		int idx = list.indexOf(x);
		if(idx < 0) {
			System.out.println("����");
		} else {
			System.out.println(idx+"�濡 �ִ�");
		}
		
		//��� 2)
		 if(list.contains(x)) {
			idx = list.indexOf(x);
			System.out.println(idx + "�濡 �ִ�");
		} else {
			System.out.println("����");
		}
		
		//��� 3)
		for(int i=0; i<list.size(); i++) {
			Member z = list.get(i);
			if(z.name.equals("bbb")) {//���⿡���� equals�� == �� ���� �ǹ� : ���ڿ��� ���� equals
				System.out.println(i+"�濡 �ִ�");
			}
		}
		
		
		//ccc ����
		list.remove(idx);//equals() ������ ���� �ʾƵ� �����
		list.remove(new Member ("ccc", "",""));//equals() ������ �ؾ���
		System.out.println(list);//toString 
		
		list.clear();//����Ʈ ��ü�� ����°� �ƴ϶� ���� ������ ����� ��
		
		if(list.isEmpty()) {
			System.out.println("����Ʈ �����");
		}
	}
}
