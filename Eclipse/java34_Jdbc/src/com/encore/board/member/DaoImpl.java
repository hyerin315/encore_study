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
		Connection conn = db.conn();//DB 연결
		String sql = "insert into member values(?,?,?,?)";//사용자가 입력하는 값에 따라 달라지도록 ?(물음표)로 작성
		//왜 이렇게 ?(물음표) 사용? sql은 문자를 ''(작은 따옴표)로 묶음 
		//(그래서 "insert into member values('"+ㅎgetId()+"','"+m.getPwd+"')'"-> 오타 나기 딱좋음)
		
		//기존에는 하드코딩으로 입력
		//insert into member values('aaa', '111', 'namea', 'aaa@email.com'); -> 하지만 이렇게 하면 새로 회원가입하는 사람은 할 수 없음
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);//자바에서 sql을 사용하려면 PreparedStatement 사용(실행할 sql문으로 preparedstatement 객체 생성)
			//요 아래는 위의 sql의 물음표에 뭐가 들어가야하는지, 물음표 매칭
			pstmt.setString(1, m.getId());//물음표 첫 번째 위치 (넘버 타입이면 serInt...타입에 따라 바꿔주면 됨)
			pstmt.setString(2, m.getPwd());//물음표 두 번째 위치
			pstmt.setString(3, m.getName());//물음표 세 번째 위치
			pstmt.setString(4, m.getEmail());//물음표 네 번째 위치
			
			//sql 실행
			cnt = pstmt.executeUpdate();//executeUpdate() : 쓰기 작업 싱행하는 함수(insert, update, delete) 실행 -> 적용된 줄 수 반환(int)
			                             //executeQuery() : 읽기 작업(select) 실행 -> 검색결과 반환(ResultSet)
			System.out.println(cnt+" 줄 insert 됨");
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
		Connection conn = db.conn();//DB 연결
		String sql = "select * from member where id=?";//?에 매개변수로 받은 id가 들어감
		ResultSet rs = null;//검색 결과 담을 변수
		Member m = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//1줄 검색되거나 없거나
			
			if(rs.next()) {//검색한 한 줄이 있냐? 있으면 true, 없으면 false
/*				//String id2 = rs.getString(1);//현재 행의 1번 컬럼 값 읽음 -> id2에 담음 (id2인 이유는 매개변수와 이름이 똑같으면 에러가 나서) -> 1) 이걸 지우게 되면
				String pwd = rs.getString(2);//현재 행의 2번 컬럼 값 읽음
				String name = rs.getString(3);//현재 행의 3번 컬럼 값 읽음
				String email = rs.getString(4);//현재 행의 4번 컬럼 값 읽음
				m = new Member(id2, pwd, name, email); //2) 여기서 id로만 써도 됨
*/
				m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));//위에거를 줄인 것 + 컬럼에 있는 값을 뽑음
			}
			
			//while(rs.next()) : 여러줄인 경우 다음 줄로 넘어가게끔 (줄을 도는 동안)
			//if(rs.next()){} : 검색한 줄이 있으면 꺼내고, 아니면 말고
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
		Connection conn = db.conn();//DB 연결
		String sql = "update member set pwd = ? where id = ?"; 
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, new_pwd);
			pstmt.setString(2, id);
			
			//sql 실행
			cnt = pstmt.executeUpdate();
			System.out.println(cnt+" 줄 update 됨");
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
		Connection conn = db.conn();//DB 연결
		String sql = "delete member where id = ?"; 
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//sql 실행
			cnt = pstmt.executeUpdate();
			System.out.println(cnt+" 줄 delete 됨");
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
