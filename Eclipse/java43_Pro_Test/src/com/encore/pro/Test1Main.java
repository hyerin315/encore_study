package com.encore.pro;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.encore.conn.DbConnect;

import oracle.jdbc.internal.OracleTypes;

public class Test1Main {
	public static void main(String[] args) {
		try {
			//DB연결
			Connection conn = DbConnect.getInstance().conn();
			if (conn != null) {
				try {
					String sql = "{call test1(?,?)}";
					CallableStatement cstmt = conn.prepareCall(sql);
					cstmt.setString(1, "Kochhar");//in parameter 매칭
					cstmt.registerOutParameter(2, OracleTypes.NVARCHAR);//out parameter 매칭
					cstmt.execute();//sql 실행
					String name = (String) cstmt.getObject(2);//(2)도 물음표 순서
					System.out.println(name);
					cstmt.close();
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

