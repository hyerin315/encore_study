package com.encore.service.define;

import java.util.ArrayList;
import java.util.Scanner;

import com.encore.vo.EmployeeSchedule;

public interface EmployeeServiceDefine {
	void getAllEmployee(Scanner sc); //��ü�������->�ܼ�â�� ����Ʈ
	void addEmpSchedule(Scanner sc); //�����������߰�->��ĵ�����Է¹޾Ƽ� �������Ͽ� ����
	void searchSchedule(Scanner sc); //���������� Ȯ��->�������� �о�ͼ� �ܼ�â�� ����Ʈ (��ü�������)�� ��ɰ�ħ
	void updateSchdule(Scanner sc);	//empcod�Է¹޾Ƽ� offday ������Ʈ
	void deleteEmployeeSchedule(Scanner sc);//empcode�Է¹޾Ƽ� ������ ����->�������Ͽ����� ����

	
	void excelRead(String path);
	void excelwrite(String path);

}

