package coll;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CollectionBean {
	private List<String> list;
	private Map<String, String> map;
	private Properties proper;
	
	public Properties getProper() {
		return proper;
	}

	public void setProper(Properties proper) {
		this.proper = proper;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
		System.out.println(">>>>>> setMap() 호출");
	}

	public CollectionBean() {
		System.out.println(">>>>>> CollectionBean 기본 생성자 호출");
	}
	
	public void setList(List<String> list) {
		this.list = list;
		System.out.println(">>>>>> setList() 호출");
	}
	
	public List<String> getList() {
		return list;
	}
}
