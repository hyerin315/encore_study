package com.encore.board.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.encore.board.conn.DbConnect;

public class DaoImpl implements Dao {
	private DbConnect db;
	
	public DaoImpl() {
		db = DbConnect.getInstance();
	}

	@Override
	public void insert(Member m) {
		Connection conn = db.conn();//DB ����
		String sql = "insert into member values(?,?,?,?)";//����ڰ� �Է��ϴ� ���� ���� �޶������� ?(����ǥ)�� �ۼ�
		//�� �̷��� ?(����ǥ) ���? sql�� ���ڸ� ''(���� ����ǥ)�� ���� 
		//(�׷��� "insert into member values('"+��getId()+"','"+m.getPwd+"')'"-> ��Ÿ ���� ������)
		
		//�������� �ϵ��ڵ����� �Է�
		//insert into member values('aaa', '111', 'namea', 'aaa@email.com'); -> ������ �̷��� �ϸ� ���� ȸ�������ϴ� ����� �� �� ����
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);//�ڹٿ��� sql�� ����Ϸ��� PreparedStatement ���(������ sql������ preparedstatement ��ü ����)
			//�� �Ʒ��� ���� sql�� ����ǥ�� ���� �����ϴ���, ����ǥ ��Ī
			pstmt.setString(1, m.getId());//����ǥ ù ��° ��ġ (�ѹ� Ÿ���̸� serInt...Ÿ�Կ� ���� �ٲ��ָ� ��)
			pstmt.setString(2, m.getPwd());//����ǥ �� ��° ��ġ
			pstmt.setString(3, m.getName());//����ǥ �� ��° ��ġ
			pstmt.setString(4, m.getEmail());//����ǥ �� ��° ��ġ
			
			//sql ����
			cnt = pstmt.executeUpdate();//executeUpdate() : ���� �۾� �����ϴ� �Լ�(insert, update, delete) ���� -> ����� �� �� ��ȯ(int)
			                             //executeQuery() : �б� �۾�(select) ���� -> �˻���� ��ȯ(ResultSet)
			System.out.println(cnt+" �� insert ��");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Member select(String id) {
		Connection conn = db.conn();//DB ����
		String sql = "select * from member where id=?";//?�� �Ű������� ���� id�� ��
		ResultSet rs = null;//�˻� ��� ���� ����
		Member m = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//1�� �˻��ǰų� ���ų�
			
			if(rs.next()) {//�˻��� �� ���� �ֳ�? ������ true, ������ false
/*				//String id2 = rs.getString(1);//���� ���� 1�� �÷� �� ���� -> id2�� ���� (id2�� ������ �Ű������� �̸��� �Ȱ����� ������ ����) -> 1) �̰� ����� �Ǹ�
				String pwd = rs.getString(2);//���� ���� 2�� �÷� �� ����
				String name = rs.getString(3);//���� ���� 3�� �÷� �� ����
				String email = rs.getString(4);//���� ���� 4�� �÷� �� ����
				m = new Member(id2, pwd, name, email); //2) ���⼭ id�θ� �ᵵ ��
*/
				m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));//�����Ÿ� ���� �� + �÷��� �ִ� ���� ����
			}
			
			//while(rs.next()) : �������� ��� ���� �ٷ� �Ѿ�Բ� (���� ���� ����)
			//if(rs.next()){} : �˻��� ���� ������ ������, �ƴϸ� ����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}

	@Override
	public void update(String id, String new_pwd) {
		Connection conn = db.conn();//DB ����
		String sql = "update member set pwd = ? where id = ?"; 
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, new_pwd);
			pstmt.setString(2, id);
			
			//sql ����
			cnt = pstmt.executeUpdate();
			System.out.println(cnt+" �� update ��");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public void delete(String id) {
		Connection conn = db.conn();//DB ����
		String sql = "delete member where id = ?"; 
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//sql ����
			cnt = pstmt.executeUpdate();
			System.out.println(cnt+" �� delete ��");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
