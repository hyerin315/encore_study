package com.encore.test;

import com.encore.child.Manager;
import com.encore.child.Students;
import com.encore.parent.Person;
import com.encore.util.MyDate;

public class PersonTest2 {
	public static void main(String[] args) {
		//상속 x
		Students s11 =  new Students("Student1", new MyDate(2000, 2, 2), "NY", "Date A");
		Students s22 =  new Students("Student2", new MyDate(1999, 3, 2), "NY", "Python");
		Students s33 =  new Students("Student3", new MyDate(2000, 11, 2), "Texas", "AI");
		Manager m11 =  new Manager("Manager1", new MyDate(1980, 1, 2), "Texas", "Marketing", 1500000, 300000);
		
//		Students[ ] sarr = {s11, s22, s33, m11};
		//배열을 만드는 전제조건 : Same Data Type --> m11은 Students 타입 아님
		//Same Data Type --> Homogeneous Collection 동종간의 콜렉션
		//Encore Academy 입장에서는 상당히 관리하기 불편한 코드가 나올 수 밖에 없다
		//왜? Homogeneous Collection이기 때문에
		
		/////////////////////////////////////////////////////////////////////////////////////
		//상속
		
		Person s1 =  new Students("Student1", new MyDate(2000, 2, 2), "NY", "Date A");
		Person s2 =  new Students("Student2", new MyDate(1999, 3, 2), "NY", "Python");
		Person s3 =  new Students("Student3", new MyDate(2000, 11, 2), "Texas", "AI");
		Person m1 =  new Manager("Manager1", new MyDate(1980, 1, 2), "Texas", "Marketing", 1500000, 300000);
		
		Person[ ] parr = {s1, s2, s3, m1};//Same Data Type이 무너지면서 --> Heterogeneous Collection
		//Encore Academy 입장에서는 상당히 관리하기 효율적인 코드가 나온다
		
		for(Person p : parr) System.out.println(p);//오버라이딩 된 toString이 자동으로 출력됨

	}
}
