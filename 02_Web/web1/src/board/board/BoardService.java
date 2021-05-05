package board.board;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.member.MemberMapper;
import resources.Factory;

public class BoardService {
private SqlSessionFactory sqlSessionFactory;
	
	public BoardService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	//�� �ۼ�
	public void addBoard(Board b) {
		SqlSession session = sqlSessionFactory.openSession(); //session open
		Dao mapper = (Dao) session.getMapper(Dao.class); //session�� ���� ���� ��ü ȹ��
		mapper.insert(b);
		session.commit();
		session.close();
	}
	
	public ArrayList<Board> getAll() {
		SqlSession session = sqlSessionFactory.openSession(); //session open
		Dao mapper = (Dao) session.getMapper(Dao.class); //session�� ���� ���� ��ü ȹ��
		ArrayList<Board> list = mapper.selectAll();
		session.close();
		return list;
		
	}
	
	public Board getByNum(int num) {
		SqlSession session = sqlSessionFactory.openSession(); //session open
		Dao mapper = (Dao) session.getMapper(Dao.class); //session�� ���� ���� ��ü ȹ��
		Board b = mapper.selectByNum(num);
		session.close();
		return b;
	}
	
	public ArrayList<Board> getByWriter(String Writer){
		SqlSession session = sqlSessionFactory.openSession(); //session open
		Dao mapper = (Dao) session.getMapper(Dao.class); //session�� ���� ���� ��ü ȹ��
		ArrayList<Board> list = mapper.selectByTitle(Writer);
		session.close();
		return list;
		
	}
	
	public ArrayList<Board> getByTitle(String title){
		SqlSession session = sqlSessionFactory.openSession(); //session open
		Dao mapper = (Dao) session.getMapper(Dao.class); //session�� ���� ���� ��ü ȹ��
		ArrayList<Board> list = mapper.selectByTitle("%"+title+"%");
		session.close();
		return list;
	}
	public void editBoard(Board b) {
		SqlSession session = sqlSessionFactory.openSession(); //session open
		Dao mapper = (Dao) session.getMapper(Dao.class); //session�� ���� ���� ��ü ȹ��
		mapper.update(b);
		session.commit();
		session.close();
	}
	public void delBoard(int num) {
		SqlSession session = sqlSessionFactory.openSession(); //session open
		Dao mapper = (Dao) session.getMapper(Dao.class); //session�� ���� ���� ��ü ȹ��
		mapper.delete(num);
		session.commit();
		session.close();
		
	}
}
