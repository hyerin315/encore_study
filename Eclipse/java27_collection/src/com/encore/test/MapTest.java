package com.encore.test;

import java.util.HashMap;
import java.util.Map;

//Map : 키와 값 같이 저장, 맵 요소는 순서가 없음
//- 키 : 값을 찾을 때, 말 그대로 키 역할을 해줌 (이전에는 방 번호로 방을 찾았다면, 여기서는 키로 검색) --> 빠르 검색 제공

public class MapTest {

	public static void main(String[] args) {		
		//상위 인터페이스
		Map<String, String> map = new HashMap<>();//HashMap, HashTable 둘 다 비슷
		//타입 지정해야함 - 키와 값 두가지를 같이 저장하니까 타입도 2개
		
		map.put("name", "aaa"); //list에서는 add / Map은 put
		map.put("tel", "111"); //키 값은 중복 불가
		map.put("address", "부산시");
		
		System.out.println(map.get("name"));//get(키): 키와 연관된 value 반환
		System.out.println(map.get("tel"));
		System.out.println(map.get("address"));
		
		String key = "name";
		if(map.containsKey("name")) {//키 묶음에서 매개변수 값 있으면 true, 아니면 false
			System.out.println(map.get(key));
		}
		
		String value = "abc";
		if(map.containsValue(value)) {
			System.out.println("abc 있다");
		} else {
			System.out.println("abc 없다");
		}
		
		map.replace("name", "anc");//키에 연관된 값 변경
		
		map.remove("name");
		
		map.clear();//전체 항목 삭제
		
		if(map.isEmpty()) {
			System.out.println("map 비었다");
		}
	}
}
