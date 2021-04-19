package com.encore.test;

import java.util.Vector;
class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}

public class VectorTestMain {

	public static void main(String[] args) {
		//옛날엔
		// Vector<String> v = new Vector<>(); 이렇게 써야 했음 --> 그런데 이렇게 하면 String 값만 받아야해서 오류뜸
		// 업데이트 되면서 안 써도 됨
		Vector v = new Vector();//옛 버전, 벡터 생성, 크기 지정 해도 되고 안해도 됨 (크기지정해도 초기값일뿐 데이터를 초과해서 넣을 수 있다 == 매모리 큰데로 이사감)
		v.add("asdf");//add(). 끝에 데이터 추가
		v.add(3.45f);
		v.add(10);
		v.add(new Point(1,2));
		v.add(1, "test");//1번방에 넣어주는데, 이전 값을 지우는게 아니라 텍스트를 끼워 넣는 것 (뒤의 값들은 한 칸씩 이동하는 것)
		
		System.out.println("데이터의 수: "+ v.size());
		System.out.println("방의 수: "+ v.capacity());
		for(int i = 0; i < v.size(); i++) {//size(): 저장된 데이터 개수 
			System.out.println(v.get(i));//get(i): i번째 방의 값 추출
		}
	}
}
