package board.member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//Mapper.xml�� ��������, DAO �������̽��� �ٷιٷ� ���ε� / ���丮���� Ŭ���� ����� �ٷιٷ� �߰�

public interface MemberMapper {
	@Insert("insert into member values(#{id}, #{pwd}, #{name}, #{email})")
	void addMember(Member m);
	
	@Select("select * from member where id=#{id}")
	Member getMember(@Param("id") String id);
	
	@Select("select * from member")
	ArrayList<Member> getMembers();
	
	@Update("update member set pwd=#{pwd}, email=#{email} where id=#{id}")
	void editMember(Member m);
	
	@Delete("delete from member where id=#{id}")
	void delMember(@Param("id") String id);
}
