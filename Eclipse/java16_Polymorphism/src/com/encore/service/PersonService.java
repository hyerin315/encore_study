package com.encore.service;
/*
 * 이 클래스를 싱글톤으로 변경하고
 * ~Test 클래스에서 객체 생성 대신에 생성한 객체를 받아와서 사용하는 코드로 수정
 */
import com.encore.child.Manager;
import com.encore.parent.Person;

public class PersonService {
	//싱글톤으로 생성
	private static PersonService service = new PersonService();
	private PersonService() {}
	public static PersonService getInstance() {
		return service;
	}


	//1. 모든 정보를 출력하는 기능
	public Person[ ] getAllPerson(Person[ ] parr) {
		Person[ ] all = new Person[parr.length];
		int idx = 0;
		for(Person p : parr) all[idx++] = p; 
		
		return all;
	}
	
	//2. 이름으로 사람 검색하기...이름은 중복 허용 안된다
	public Person findPersonByName(Person[ ] parr, String name) {
		Person person = null;
		for(Person p : parr) 
			if(p.getName().equals(name)) person = p;
		
		return person;
	}
	
	//3. 특정한 사람의 연봉을 반환
	public int getAnnualSalary(Person[ ] parr, Person p) {
		int annualSalary = 0;
		for(Person per : parr) {
			if(per instanceof Manager) {
				annualSalary = ((Manager) per).getSalary() * 12 + ((Manager) per).getBonus();
			}
		}
		return annualSalary;
	}
	
	//4. 총 인건비
	public int getTotalCost(Person[ ] parr) {
		int total = 0;
		for(Person p : parr) {
			if(p instanceof Manager) 
				total += getAnnualSalary(parr, p);
			}
		return total;
	}
}
