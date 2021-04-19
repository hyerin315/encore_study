package com.encore.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Iterator(반복자) : 리스트나 맵에서 다음 방 이동 및 데이터 추출을 반복 수행

public class InterTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		Iterator<String> it = list.iterator();//iterator 생성 - 내가 받을 list로 받아서 함수 호출해서 생성
		while (it.hasNext()) {//hasNext() : 읽을 요소가 있으면 true, 없으면 false
			System.out.println(it.next());//다음 칸 이동해서 값 추출
		}
		
		Map<String,String> map = new HashMap<>();
		map.put("name", "aaa"); 
		map.put("tel", "111"); 
		map.put("address", "부산시");
		
		Iterator<String> keys = map.keySet().iterator();//키 묶음에 연결된 반복자 생성
		while(keys.hasNext()) {
			String key = keys.next();
			String val = map.get(key);
			System.out.println(key+":"+val);
		}
		
		Iterator<String> values = map.values().iterator();//값 묶음에 연결된 반복자 생성
		while(values.hasNext()) {
			System.out.println(values.next());
		}
	}
}
