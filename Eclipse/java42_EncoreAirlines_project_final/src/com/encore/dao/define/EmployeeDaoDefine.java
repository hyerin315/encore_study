package com.encore.dao.define;

import java.util.ArrayList;

import com.encore.vo.EmployeeSchedule;

public interface EmployeeDaoDefine {
	ArrayList <EmployeeSchedule> getAllEmployee(); //������� ȣ��
	ArrayList<EmployeeSchedule> addEmpSchedule(EmployeeSchedule e);//���������ٵ��
	EmployeeSchedule searchSchedule(String empCode);//empcode�� �˻��ؼ� ������ �˻�
	void updateSchdule(String empCode, String offday);//empcode�� �˻��ؼ� ���Ͼ�����Ʈ
	void deleteEmployeeSchedule (String empCode);//empcode�� �޾Ƽ� ����
	EmployeeSchedule selectByEmpCode(String eNum);
}