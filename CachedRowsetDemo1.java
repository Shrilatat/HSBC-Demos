package com.trg.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowsetDemo1 {
	public static void main(String[] args) {
		CachedRowSet rs = null;
		try {
			RowSetFactory factory = RowSetProvider.newFactory();
			rs = factory.createCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			rs.setUsername("oracle");
			rs.setPassword("oracle123");
			rs.setCommand("select bookid, price from book");
			String sql = "select empno, ename, sal from emp " + 
			          " where sal >= 2000 and sal <= 5500";
			rs.setCommand(sql);
			rs.execute();
			System.out.println("Row Count: " + rs.size());
			rs.execute();
			while (rs.next()) {
				System.out.println(rs.getString(2) + ":" 
			             + rs.getString(3));
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
