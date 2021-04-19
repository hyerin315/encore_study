package com.encore.service;
import com.encore.inter.Dao;

//service : ����Ͻ� ���� ���� Ŭ����(��� ����)

public class Service {
	private Dao dao;//������ �����ϰ� �Ϸ��� �������̽� Ÿ������ ����
	
	//������ ����
	public Service(Dao dao) {//��ĳ���� �Ű����� --> Dao�� �ؼ� �������⼭ �� �� �ֵ���
		this.dao = dao;
	}
	
	public void add() {
		dao.insert();
		
	}
	
	public void get() {
		dao.select();
	}
	
	public void edit() {
		dao.update();
	}
	
	public void del() {
		dao.delete();
	}

}
