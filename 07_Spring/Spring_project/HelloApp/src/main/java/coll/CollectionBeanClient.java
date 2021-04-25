package coll;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("app-context2.xml");
		
		CollectionBean coll = (CollectionBean) factory.getBean("coll");
		List<String> list = coll.getList();
		
		for(String li:list) {
			System.out.println(li);
		}
		
		Map<String, String> map = coll.getMap();
		System.out.println(map.entrySet());
		
		Properties proper = coll.getProper();
		System.out.println(proper);
		
		factory.close();

	}

}
