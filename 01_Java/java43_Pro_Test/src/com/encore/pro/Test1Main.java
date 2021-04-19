package com.encore.pro;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.encore.conn.DbConnect;

import oracle.jdbc.internal.OracleTypes;

public class Test1Main {
	public static void main(String[] args) {
		try {
			//DB����
			Connection conn = DbConnect.getInstance().conn();
			if (conn != null) {
				try {
					String sql = "{call test1(?,?)}";
					CallableStatement cstmt = conn.prepareCall(sql);
					cstmt.setString(1, "Kochhar");//in parameter ��Ī
					cstmt.registerOutParameter(2, OracleTypes.NVARCHAR);//out parameter ��Ī
					cstmt.execute();//sql ����
					String name = (String) cstmt.getObject(2);//(2)�� ����ǥ ����
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

