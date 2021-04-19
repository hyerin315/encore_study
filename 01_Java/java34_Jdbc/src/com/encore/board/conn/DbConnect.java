package com.encore.board.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {//DB ���� �ڵ�
	private static DbConnect db = new DbConnect();
	
	private String driver = "oracle.jdbc.driver.OracleDriver";//����Ŭ�� ����̹���
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";//�α��ο� �ʿ��� �����ּ� �� sid
	//���ΰ� �˰� ������ �۾������� - ���� �� ��� ����Ŭ���� �޺κ� xe(sid)���� Ȯ��
	
	private DbConnect() {}
	
	public static DbConnect getInstance() {
		return db;
	}
	
	public Connection conn() {
		Connection conn = null;
		try {
			Class.forName(driver);//����̹� �ε� : ����̹��� �ִ� ���� �ҷ��� �� �ְԲ�
			conn = DriverManager.getConnection(url, "hr", "hr");//DB������ ����(�α��� �Լ�)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} return conn;
	}
}