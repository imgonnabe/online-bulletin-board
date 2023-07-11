package com.poseidon.db;

import java.sql.Connection;
import java.sql.DriverManager;

// static 싱글톤
public class DBConnection {
	private static DBConnection dbConn = null;
	
	// 생성자
	private DBConnection() {
	}
	
	// 싱글톤 인스턴스를 반환하는 메소드
	public synchronized static DBConnection getInstance() {
		if (dbConn == null) {
			dbConn = new DBConnection();
		}
		return dbConn;
	}
	
	// getConn
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mariadb://localhost:3306/choongang";
		String id = "qorlwn";
		String pw = "123456789";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
