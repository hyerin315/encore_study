package board.member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//Mapper.xml이 없어지고, DAO 인터페이스에 바로바로 업로드 / 펙토리에서 클래스 만들어 바로바로 추가

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
