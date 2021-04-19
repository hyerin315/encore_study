package com.encore.board.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.board.conn.DbConnect;

public class DaoImpl implements Dao {
	private DbConnect db;
	
	public DaoImpl() {
		db = DbConnect.getInstance();
	}

	@Override
	public void insert(Board b) {
		Connection conn = db.conn();//DB 연결
		String sql = "insert into board values(seq_board.nextval,?,sysdate,?,?)";
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			
			cnt = pstmt.executeUpdate();
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
	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		String sql = "select * from board order by num";
		Connection conn = db.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));//각 컬럼의 값을 읽어서 보드 객체 생성
				list.add(b);//어레이리스트에 담아
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Board selectByNum(int num) {
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		String sql = "select * from board where num = ?";
		Connection conn = db.conn();
		Board b = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));//각 컬럼의 값을 읽어서 보드 객체 생성
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
	}

	@Override
	public ArrayList<Board> selectByWriter(String writer) {
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		String sql = "select * from board where writer = ?";
		Connection conn = db.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));//각 컬럼의 값을 읽어서 보드 객체 생성
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ArrayList<Board> selectByTitle(String title) {
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		String sql = "select * from board where title like ?";
		Connection conn = db.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));//각 컬럼의 값을 읽어서 보드 객체 생성
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void update(Board b) {
		Connection conn = db.conn();//DB 연결
		String sql = "update board set w_date=sysdate, title=?, content=?, where num=?";
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());
			
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
	public void delete(int num) {
		Connection conn = db.conn();//DB 연결
		String sql = "delete board where num=?";
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
