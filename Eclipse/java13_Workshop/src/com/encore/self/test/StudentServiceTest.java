package com.encore.self.test;

import com.encore.self.service.StudentService;
import com.encore.self.vo.Student;

public class StudentServiceTest {
	public static void main(String[] args) {
		StudentService service = new StudentService();
		
		//메소드를 각각 호출
		System.out.println("===========1. addStudent=============");
		service.addStudent(new Student(100,"김구라", "구로동", 51, "a20200001"));
		service.addStudent(new Student(111,"나은", "논현동", 28, "b20200002"));
		service.addStudent(new Student(222,"도라에몽", "동원동", 8, "c20200003"));
		service.addStudent(new Student(333,"롤리폴리", "논현동", 22, "d20200004"));
	
		
		System.out.println("===========Student 정보 확인=============");
		service.printStudentInfo();
		
		System.out.println("===========2. deletStudent=============");
		service.deleteStudent(222);
		
		System.out.println("===========Student 정보 확인=============");
		service.printStudentInfo();
		
		System.out.println("===========3. findStudent=============");
		System.out.println(service.findStudent(333).getDetails());
		
		System.out.println("===========3. findStudent=============");
		Student[ ] students=service.findStudent("논현동");
		for(Student s : students) {
			if(s==null) continue;
			System.out.println(s.getDetails());
		}
		//직접 작성
		//Service의 기능을 잘 호출

	}

}
