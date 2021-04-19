package com.encore.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Iterator(�ݺ���) : ����Ʈ�� �ʿ��� ���� �� �̵� �� ������ ������ �ݺ� ����

public class InterTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		Iterator<String> it = list.iterator();//iterator ���� - ���� ���� list�� �޾Ƽ� �Լ� ȣ���ؼ� ����
		while (it.hasNext()) {//hasNext() : ���� ��Ұ� ������ true, ������ false
			System.out.println(it.next());//���� ĭ �̵��ؼ� �� ����
		}
		
		Map<String,String> map = new HashMap<>();
		map.put("name", "aaa"); 
		map.put("tel", "111"); 
		map.put("address", "�λ��");
		
		Iterator<String> keys = map.keySet().iterator();//Ű ������ ����� �ݺ��� ����
		while(keys.hasNext()) {
			String key = keys.next();
			String val = map.get(key);
			System.out.println(key+":"+val);
		}
		
		Iterator<String> values = map.values().iterator();//�� ������ ����� �ݺ��� ����
		while(values.hasNext()) {
			System.out.println(values.next());
		}
	}
}
