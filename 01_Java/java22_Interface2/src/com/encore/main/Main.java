package com.encore.main;

import com.encore.inter.Daoimpl_Mysql;
import com.encore.inter.Daoimpl_Oracle;
import com.encore.service.Service;

public class Main {

	public static void main(String[] args) {
		//Service service = new Service(new Daoimpl_Oracle());
		/*
		 * Mysql mysql = new Daoimpl_Mysql();
		 * ervice service = new Service(mysql); �� ���������� �Ʒ�ó�� ǥ��
		 */
		Service service = new Service(new Daoimpl_Mysql());
		
		//��ü �̸��� �ٲ��൵ �ڵ� �۵��� Ȯ �޶��� -> �������̽��� ��ӹ޾� �����ϴ� ��� 
		//�������̽��� ���� == ���α׷� ���������ϱ� ������
		
		service.add();
		service.get();
		service.edit();
		service.del();
	}
}

