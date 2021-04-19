package com.encore.board.member;

//Dao : DB�� ���õ� �ϸ� �ؾ���

public interface Dao {
	//ȸ������ ��ɿ� �ʿ� : service���� id,pwd,name,email�� Member ��ü�� ��Ƽ� insert()ȣ�� -> DB�� �����϶��
	void insert(Member m);
	
	//service�� login, �� ���� Ȯ��
	Member select(String id);
	
	//service�� �� ���� ���� (���ο� pwd�� �޾ƶ�) : �и��Ǹ� ���� ������? ��ĥ �� �� �κи� ��ġ�� ��
	void update(String id, String new_pwd);
	
	//service�� Ż��
	void delete(String id);
}
