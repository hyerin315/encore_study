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
		//이름만 같으면 같은 객체
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
		list.add(new Member("aaa", "111", "대한민국"));
		list.add(new Member("bbb", "222", "서초구"));
		list.add(new Member("ccc", "333", "역삼동"));
		
		//이름이 bbb인 사람을 검색
		//if(list.contains(new Member("bbb","222","서초구"))) {//contains는 equals()로 비교 (재정의를 안해주면 참조값으로만 찾음)
		//x.equals(new Member("bbb",",",",")): Member의 equals()를 호출
		
		//방법 1)
		Member x = new Member("bbb",",",",");//멤버 객체를 만들어줘야 방법 2에서 멤버에서 같은지 아닌지 확인할 수 있음
		int idx = list.indexOf(x);
		if(idx < 0) {
			System.out.println("없다");
		} else {
			System.out.println(idx+"방에 있다");
		}
		
		//방법 2)
		 if(list.contains(x)) {
			idx = list.indexOf(x);
			System.out.println(idx + "방에 있다");
		} else {
			System.out.println("없다");
		}
		
		//방법 3)
		for(int i=0; i<list.size(); i++) {
			Member z = list.get(i);
			if(z.name.equals("bbb")) {//여기에서의 equals는 == 과 같은 의미 : 문자열에 대한 equals
				System.out.println(i+"방에 있다");
			}
		}
		
		
		//ccc 삭제
		list.remove(idx);//equals() 재정의 하지 않아도 실행됨
		list.remove(new Member ("ccc", "",""));//equals() 재정의 해야함
		System.out.println(list);//toString 
		
		list.clear();//리스트 자체를 지우는게 아니라 안의 내용을 지우는 것
		
		if(list.isEmpty()) {
			System.out.println("리스트 비었음");
		}
	}
}
