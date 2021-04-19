package com.encore.child.service;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.parent.Employee;

public class PolyMorphismService {
	//1. step1
	/* public void handleManager(Manager m) {   }
	public void handleEngineer(Engineer eg) {   }
	public void handleSecretary(Secretary s) {   }  */
	
	//2. step2
	//public void handleEmployee(Employee e) {   }//Manager, Engineer, Secretary 개인적으로 하나하나 밖에 안된다는 단점
	
	//3. step3
	public void handleEmployee(Employee[ ] earr) {
		for(Employee e : earr) {
			if(e instanceof Manager) {//Manager 객체만 true
				if(e.getName().equals("James"))
					((Manager)e).changeDept("기획부");
			}
			if(e instanceof Engineer)
				if(e.getName().equals("Engineer"));
					//((Engineer)e).changeTech("Pytorch");
		}
	}
}
//상속과 폴리몰피즘
/*
 * JavaDoc...한글처리 : euc-kr
 * Object Aid : 이클립스에 PlugIn 직접 하기
 * 소스 코드 작성하고 캡쳐해서 포함하기 (그냥 코드 여러개 잡아서 창에 얹으면 됨)
 * 
 */
