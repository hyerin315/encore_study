package com.encore.self.service;

import com.encore.self.vo.Student;

public class StudentService {
	private Student[ ] students;
	int index;
	
	//������� constance�� �� : ������ �ʴ� ������ ��(������ �� = public)
	//������� �ݵ�� �빮��_�빮��(ī�����̽� ����X)
	public static final int MAX_SIZE = 10;//������ �� = �ϰ����� ������ �� --> �����ϸ� �ȵ� (������� static�� ���� ������ ����)
	

	public StudentService() {//���񽺰� �����ʰ� ���ÿ� ����� �ϴ� �͵� �Բ� ������
		students = new Student[MAX_SIZE];//10�� ����
	}

	//CRUD ����� ����...
	public void addStudent(Student s) {//�߰��ϰ��� �ϴ� �л��� �迭 �ȿ� �־����
		if(index==MAX_SIZE && s==null) {//�����̳ʰ� ��� ���� + �л��� �������� �ʰ� �־��� ��
			System.out.println("���̻� �л��� ���� �� ���ų� �߰��Ϸ��� �л��� �������� �ʽ��ϴ�.");
			return; 
		}
		students[index++]=s;
	}
	
	public void deleteStudent(int ssn) {
		//index��ŭ ���鼭 ���� ����� index�� ã�°� �� ���� --> ������ �ε������� �����ؼ� �ڿ� ���� ���� ���� �� �ֵ���
		for(int i=0; i<index; i++) {
			if(students[i].getSsn()==ssn) {//�Ȱ��� �ָ� ������ �ű⼭ ���� ����
				for(int j=i; j<index; j++) {
					students[j] = students[j+1];
				}//����� �� �� ������ �� �������� ����
				students[index] = null;
				index--;
			}
		}
			
		
	}
	//Method Overloading!!
	public Student findStudent(int ssn) {
		Student student = null;
		for(Student s : students) {
			if(s==null) continue;
			if(s.getSsn()==ssn) student = s;
		}
		return student;
	}
	public Student[ ] findStudent(String address) {
		Student[ ] temp = new Student[index];
		int count = 0;
		for(Student s : students) {
			if(s==null) continue;
			if(s.getAddress().equals(address)) {
				temp[count++] = s;
			}
		}
		return temp;
	}
	
	public void printStudentInfo() {
		for(Student s : students) {
			if(s==null) continue;
			System.out.println(s.getDetails());
		}
			
	}
}
