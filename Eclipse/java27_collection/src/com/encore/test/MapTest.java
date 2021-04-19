package com.encore.test;

import java.util.HashMap;
import java.util.Map;

//Map : Ű�� �� ���� ����, �� ��Ҵ� ������ ����
//- Ű : ���� ã�� ��, �� �״�� Ű ������ ���� (�������� �� ��ȣ�� ���� ã�Ҵٸ�, ���⼭�� Ű�� �˻�) --> ���� �˻� ����

public class MapTest {

	public static void main(String[] args) {		
		//���� �������̽�
		Map<String, String> map = new HashMap<>();//HashMap, HashTable �� �� ���
		//Ÿ�� �����ؾ��� - Ű�� �� �ΰ����� ���� �����ϴϱ� Ÿ�Ե� 2��
		
		map.put("name", "aaa"); //list������ add / Map�� put
		map.put("tel", "111"); //Ű ���� �ߺ� �Ұ�
		map.put("address", "�λ��");
		
		System.out.println(map.get("name"));//get(Ű): Ű�� ������ value ��ȯ
		System.out.println(map.get("tel"));
		System.out.println(map.get("address"));
		
		String key = "name";
		if(map.containsKey("name")) {//Ű �������� �Ű����� �� ������ true, �ƴϸ� false
			System.out.println(map.get(key));
		}
		
		String value = "abc";
		if(map.containsValue(value)) {
			System.out.println("abc �ִ�");
		} else {
			System.out.println("abc ����");
		}
		
		map.replace("name", "anc");//Ű�� ������ �� ����
		
		map.remove("name");
		
		map.clear();//��ü �׸� ����
		
		if(map.isEmpty()) {
			System.out.println("map �����");
		}
	}
}
