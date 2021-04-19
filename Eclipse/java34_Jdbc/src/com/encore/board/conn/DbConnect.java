package com.encore.board.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {//DB 연결 코드
	private static DbConnect db = new DbConnect();
	
	private String driver = "oracle.jdbc.driver.OracleDriver";//오라클용 드라이버명
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";//로그인에 필요한 서버주소 및 sid
	//본인거 알고 싶으면 작업관리자 - 서비스 탭 열어서 오라클서비스 뒷부분 xe(sid)인지 확인
	
	private DbConnect() {}
	
	public static DbConnect getInstance() {
		return db;
	}
	
	public Connection conn() {
		Connection conn = null;
		try {
			Class.forName(driver);//드라이버 로드 : 드라이버에 있는 것을 불러올 수 있게끔
			conn = DriverManager.getConnection(url, "hr", "hr");//DB서버에 접속(로그인 함수)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} return conn;
	}
}