package board.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resources.Factory;


public class MemberService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public void addMember(Member m){
		SqlSession session = sqlSessionFactory.openSession(); //session open (하나의 네트워크가 상대방이 접속을 끝낼때까지 있는 게 세션이라고 함)
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class); //session(db연결을 관리하는 객체 == conn과 비슷)을 통해 매퍼 객체 획득 / MemberMapper.class는 매퍼 객체 의미 
		mapper.addMember(m);
		session.commit();
		session.close();
	}
	
	public Member getMember(String id){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		Member m = mapper.getMember(id);
		session.close();
		return m;
	}
	
	public ArrayList<Member> getMembers(){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		ArrayList<Member> list = mapper.getMembers();
		session.close();
		return list;
	}
	
	public void editMember(Member m){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		mapper.editMember(m);
		session.commit();
		session.close();
	}
	
	public void delMember(String id){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		mapper.delMember(id);
		session.commit();
		session.close();
	}
}

