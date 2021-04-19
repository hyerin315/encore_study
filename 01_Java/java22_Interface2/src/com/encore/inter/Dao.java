package com.encore.inter;

//인터페이스 : 상수와 추상메소드로만 구성된 완전 추상 클래스
//JDBC(java databases connectivity) : 자바랑 데이터 베이스 연결해주는 인터페이스
//--> 자바는 이 인터페이스를 다른 회사에 배포해서 안의 내용은 각각 회사들이 자기 제품에 맞게 구현(ex.오라클, SQL 등등) --> 이게 드라이버

//DAO를 클래스로 만들지 않고 인터페이스로 만든 이유
//- 다른 코드와 연결하는 면 역할 (다른 코드와 떼었다 붙였다 할 수 있는 경계면)
//
public interface Dao {//Database Access object - DB 담당 클래스
	void insert();
	void select();
	void update();
	void delete();
	
}
