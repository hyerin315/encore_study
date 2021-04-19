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
	//public void handleEmployee(Employee e) {   }//Manager, Engineer, Secretary ���������� �ϳ��ϳ� �ۿ� �ȵȴٴ� ����
	
	//3. step3
	public void handleEmployee(Employee[ ] earr) {
		for(Employee e : earr) {
			if(e instanceof Manager) {//Manager ��ü�� true
				if(e.getName().equals("James"))
					((Manager)e).changeDept("��ȹ��");
			}
			if(e instanceof Engineer)
				if(e.getName().equals("Engineer"));
					//((Engineer)e).changeTech("Pytorch");
		}
	}
}
//��Ӱ� ����������
/*
 * JavaDoc...�ѱ�ó�� : euc-kr
 * Object Aid : ��Ŭ������ PlugIn ���� �ϱ�
 * �ҽ� �ڵ� �ۼ��ϰ� ĸ���ؼ� �����ϱ� (�׳� �ڵ� ������ ��Ƽ� â�� ������ ��)
 * 
 */
