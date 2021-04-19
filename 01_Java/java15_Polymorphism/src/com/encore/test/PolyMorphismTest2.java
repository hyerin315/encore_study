package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.service.PolyMorphismService;
import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class PolyMorphismTest2 {
	public static void main(String[] args) {
		Employee e = new Employee("Employee", new MyDate(1999,1,1), 20000.0);
		Employee m = new Manager("James", new MyDate(1990,2,1), 20000.0, "개발부");
		Employee eg = new Engineer("Engineer", new MyDate(1985,3,1), 30000.0, 100.0, "Java");
		Employee m1 = new Manager("James1", new MyDate(1985,3,1), 50000.0, "총무부");
		Employee eg1 = new Engineer("Engineer2", new MyDate(1985,3,1), 30000.0, 100.0, "c++");
		
		//Heterogeneous Collection....배열 = Same Data Type.X ---> 상속으로 인해 무너짐
		Employee[ ] emps = {e,m,eg,m1,eg1};
		
		PolyMorphismService service = new PolyMorphismService();
		service.handleEmployee(emps);
	}

}
