package com.encore.test;

import java.util.ArrayList;

//ArrayList : 일반적인 상황에서는 Vector보다 '가볍기 때문에' 낫다 (여러곳에서 쓰지 않으면 동기화 안해줘도 됨)
//Vector : 동시에 여러곳에서 쓰는 상황에서는 Vector을 쓰는 게 낫다

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();//Vector와 거의 동일하지만, 벡터의 동기화가 빠짐
		list.add("aaa");
		list.add("bbb");
		list.add(0, "ccc");
		list.add(0, "ddd");//set(): 수정
		
		
		System.out.println("전체 출력");
		for(String s : list) {//get()으로 추출 가능
			System.out.println(s);
		}
		
		if(list.contains("bbb")) {//list에 매개변수로 지정한 값이 있으면 true, 없으면 false
			System.out.println(list.indexOf("bbb")+" 에 있음");//indexOf(): 매개변수 값이 있는 곳의 인덱스 반환
		} else {
			System.out.println("없다");
		}
		
		list.remove(1);//1반빙 삭제
		list.remove("ddd");//매개변수로 넣은 값과 동일한 객체를 찾아서 삭제
		
		//remove(), contain(), indexOf()는 equals() 객체를 비교 --> 주소값 찾아서 비교
		
		if(list.isEmpty()) {//isEmty(): list가 비었으면 true, 아니면 false
			System.out.println("전체 출력");
			for(String s : list) {//get()으로 추출 가능
				System.out.println(s);
			}
		}
	}
}
