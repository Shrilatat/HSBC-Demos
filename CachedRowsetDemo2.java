package com.trg.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowsetDemo2 {
	public static void main(String[] args) {
		CachedRowSet rs = null;
		try {
			RowSetFactory factory = RowSetProvider.newFactory();
			rs = factory.createCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			rs.setUsername("oracle");
			rs.setPassword("oracle123");
			rs.setCommand("select * from dept");
			rs.execute();
			rs.moveToInsertRow();
			// Set the values for columns in the new row
			rs.updateInt("deptno", 60);
			rs.updateString("dname", "Research");
			rs.updateString("loc", "Pune");
			// Insert the new row in the rowset. It is not sent to the
			// database, until the acceptChanges() method is called
			rs.insertRow();
			// Must move back to the current row
			rs.moveToCurrentRow();
			rs.acceptChanges();
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
