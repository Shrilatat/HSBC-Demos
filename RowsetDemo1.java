package com.trg.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowsetDemo1 {
	public static void main(String[] args) {
		JdbcRowSet rs = null;
		try {
			// Get the RowSetFactory implementation
			RowSetFactory factory = RowSetProvider.newFactory();
			// Create a JdbcRowSet object
			rs = factory.createJdbcRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			rs.setUsername("oracle");
			rs.setPassword("oracle123");
			rs.setCommand("select * from emp");
			rs.execute();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
