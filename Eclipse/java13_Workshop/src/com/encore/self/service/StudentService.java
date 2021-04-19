package com.encore.self.service;

import com.encore.self.vo.Student;

public class StudentService {
	private Student[ ] students;
	int index;
	
	//상수값은 constance한 값 : 변하지 않는 고정된 값(공공의 값 = public)
	//상수값은 반드시 대문자_대문자(카멜케이스 적용X)
	public static final int MAX_SIZE = 10;//마지막 값 = 일관성을 가지는 값 --> 수정하면 안됨 (상수값은 static도 같이 가지고 있음)
	

	public StudentService() {//서비스가 생성됨과 동시에 담고자 하는 것도 함께 생성함
		students = new Student[MAX_SIZE];//10명 정도
	}

	//CRUD 기능을 정의...
	public void addStudent(Student s) {//추가하고자 하는 학생을 배열 안에 넣어야함
		if(index==MAX_SIZE && s==null) {//컨테이너가 계속 차면 + 학생을 생성하지 않고 넣었을 때
			System.out.println("더이상 학생을 받을 수 없거나 추가하려는 학생이 존재하지 않습니다.");
			return; 
		}
		students[index++]=s;
	}
	
	public void deleteStudent(int ssn) {
		//index만큼 돌면서 삭제 대상의 index를 찾는게 더 좋음 --> 삭제된 인덱스부터 시작해서 뒤에 값이 앞을 덮을 수 있도록
		for(int i=0; i<index; i++) {
			if(students[i].getSsn()==ssn) {//똑같은 애를 만나면 거기서 부터 돌게
				for(int j=i; j<index; j++) {
					students[j] = students[j+1];
				}//덮어쓰는 걸 다 끝내면 맨 마지막은 감소
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
