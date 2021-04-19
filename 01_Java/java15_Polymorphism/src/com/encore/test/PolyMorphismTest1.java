package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.parent.Employee;
import com.encore.util.MyDate;
/*
 * 부모 타입으로 자식 객체를 생성하면 발생하는 문제점
 * Object Casting으로 해결한다
 */

public class PolyMorphismTest1 {
	public static void main(String[] args) {
		Employee e = new Employee("Employee", new MyDate(1999,1,1), 20000.0);
		Employee m = new Manager("James", new MyDate(1990,2,1), 20000.0, "개발부");
		Employee eg = new Engineer("Engineer", new MyDate(1985,3,1), 30000.0, 100.0, "Java");
		
		//James의 부서를 개발부에서 교육부로 변경
		//m.change("교육부");
		//--> Employee의 타입으로 매니저가 올라갔기 때문에 Employee에는 changeDept가 없으므로
		//    Employee가 아니라 Manager에서 찾도록 불러줘야한다 --> Object Casting
		//캐스팅 형태 ()m; --> ()에서 찾아!!!
		/*1) 
		 * Manager m1 = (Manager)m;
		   m1.changeDept("교육부"); */
		//2)
		((Manager) m).changeDept("교육부");//하나하나 추가하면서 핸들링하지 않기 위해 Test2.Topic 배움
		
		System.out.println(e.getDetails());
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());

	}

}
