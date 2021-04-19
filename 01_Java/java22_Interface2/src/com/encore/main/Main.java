package com.encore.main;

import com.encore.inter.Daoimpl_Mysql;
import com.encore.inter.Daoimpl_Oracle;
import com.encore.service.Service;

public class Main {

	public static void main(String[] args) {
		//Service service = new Service(new Daoimpl_Oracle());
		/*
		 * Mysql mysql = new Daoimpl_Mysql();
		 * ervice service = new Service(mysql); 을 함축적으로 아래처럼 표현
		 */
		Service service = new Service(new Daoimpl_Mysql());
		
		//객체 이름만 바꿔줘도 코드 작동이 확 달라짐 -> 인터페이스를 상속받아 조립하는 방법 
		//인터페이스형 개발 == 프로그램 유지보수하기 좋아짐
		
		service.add();
		service.get();
		service.edit();
		service.del();
	}
}

