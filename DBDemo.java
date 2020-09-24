package com.trg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemo {

	Connection conn=null;
	
	public DBDemo() {
		conn= DBConnection.getConnection();
	}
	
	
	public void add() throws SQLException {
		
		int eid = 109;
		String name = "Parth";
		int sal=8000;
		
		String sql = "insert into emp values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, eid);
		pstmt.setString(2, name);
		pstmt.setInt(3, sal);
		
		int count = pstmt.executeUpdate();

	}
	
	public static void main(String[] args) {

		
		
	}

}
