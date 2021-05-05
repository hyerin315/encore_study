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
		SqlSession session = sqlSessionFactory.openSession(); //session open (�ϳ��� ��Ʈ��ũ�� ������ ������ ���������� �ִ� �� �����̶�� ��)
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class); //session(db������ �����ϴ� ��ü == conn�� ���)�� ���� ���� ��ü ȹ�� / MemberMapper.class�� ���� ��ü �ǹ� 
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

