package board.member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

//MyBatis ����ϸ� Dao Imple �ȸ��� ��
//dao interface -> mybatis������ mapper interface
//sqlmap.MemberMapper ���� �̸��� �Ȱ��ƾ��� �ʿ�� ����, �׳� ���� ���϶�� �׷��� �����ص�

public interface MemberMapper {
	void addMember(Member m);
	Member getMember(String id);
	ArrayList<Member> getMembers();
	void editMember(Member m);
	void delMember(String id);
}
