package board.member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

//MyBatis 사용하면 Dao Imple 안만들어도 됨
//dao interface -> mybatis에서는 mapper interface
//sqlmap.MemberMapper 파일 이름이 똑같아야할 필요는 없음, 그냥 보기 편하라고 그렇게 지정해둠

public interface MemberMapper {
	void addMember(Member m);
	Member getMember(String id);
	ArrayList<Member> getMembers();
	void editMember(Member m);
	void delMember(String id);
}
