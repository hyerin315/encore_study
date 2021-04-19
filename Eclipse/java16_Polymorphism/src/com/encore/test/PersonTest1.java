package com.encore.test;

import com.encore.child.Manager;
import com.encore.child.Students;
import com.encore.parent.Person;
import com.encore.util.MyDate;

/*
 * PolyMorphism
 * 하나의 타입으로 --- Super Type
 * 여러개의 객체를 생성하는 기법 --- Sub Classes Creating
 */
public class PersonTest1 {
	public static void main(String[] args) {
		//부모타입으로 자식을 만든다
		Person s1 =  new Students("Student1", new MyDate(2000, 2, 2), "NY", "Date A");
		Person s2 =  new Students("Student2", new MyDate(1999, 3, 2), "NY", "Python");
		Person s3 =  new Students("Student3", new MyDate(2000, 11, 2), "Texas", "AI");
		Person m1 =  new Manager("Manager1", new MyDate(1980, 1, 2), "Texas", "Marketing", 1500000, 300000);
		
		//폴리몰피즘으로 객체를 생성하면 아래 두가지 변화를 반드시 이해해야 합니다
		//1. Manager1의 부서를 IT 부서로 변경하시고 다시 정보를 확인하세요 -- Object Casting
		((Manager) m1).changeDept("IT");//매니저에서 찾아!!!
		
		//2. 각각 객체의 모든 정보를 출력하세요 -- Virtual Method(가상의 메소드 --> 자식 메소드 호출) Invocation 
		/*
		 * 상속관계에서 오버라이딩된 메소드에서만 나타나는 원리이다.
		 * Person s = New Student();
		 * 1) Compile 시점의 Method - 부모의 메소드를 호출 : toString()
		 * 2) Runtime(실행) 시점의 Method - 자식의 메소드를 호출 : toString() 
		 *    --> 부모꺼를 고쳐 썼는데 부모와 자식은 이어져 있기 때문에 실행시점에서는 생성된 자식의 메소드 호출(이례적)
		 *    
		 * 		System.out.println(m1.getDept());//이건 매니저만의 메소드임 --> 자식만의 메소드이기 때문에 호출이 안됨
		 *      그래서  System.out.println((Manager)m1).getDept()); 해야하는데 이게 바로 Object Casting
		 */
		System.out.println(s1);//.toString은 생략되어 있음
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(m1);
		


	}
}
