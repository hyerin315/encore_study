package com.encore.board.member;

//Dao : DB와 관련된 일만 해야함

public interface Dao {
	//회원가입 기능에 필요 : service에서 id,pwd,name,email을 Member 객체에 담아서 insert()호출 -> DB에 저장하라고
	void insert(Member m);
	
	//service의 login, 내 정보 확인
	Member select(String id);
	
	//service의 내 정보 수정 (새로운 pwd를 받아라) : 분리되면 뭐가 좋을까? 고칠 때 한 부분만 고치면 됨
	void update(String id, String new_pwd);
	
	//service의 탈퇴
	void delete(String id);
}
