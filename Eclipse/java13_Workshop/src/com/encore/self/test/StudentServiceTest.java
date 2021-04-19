package com.encore.self.test;

import com.encore.self.service.StudentService;
import com.encore.self.vo.Student;

public class StudentServiceTest {
	public static void main(String[] args) {
		StudentService service = new StudentService();
		
		//�޼ҵ带 ���� ȣ��
		System.out.println("===========1. addStudent=============");
		service.addStudent(new Student(100,"�豸��", "���ε�", 51, "a20200001"));
		service.addStudent(new Student(111,"����", "������", 28, "b20200002"));
		service.addStudent(new Student(222,"���󿡸�", "������", 8, "c20200003"));
		service.addStudent(new Student(333,"�Ѹ�����", "������", 22, "d20200004"));
	
		
		System.out.println("===========Student ���� Ȯ��=============");
		service.printStudentInfo();
		
		System.out.println("===========2. deletStudent=============");
		service.deleteStudent(222);
		
		System.out.println("===========Student ���� Ȯ��=============");
		service.printStudentInfo();
		
		System.out.println("===========3. findStudent=============");
		System.out.println(service.findStudent(333).getDetails());
		
		System.out.println("===========3. findStudent=============");
		Student[ ] students=service.findStudent("������");
		for(Student s : students) {
			if(s==null) continue;
			System.out.println(s.getDetails());
		}
		//���� �ۼ�
		//Service�� ����� �� ȣ��

	}

}
