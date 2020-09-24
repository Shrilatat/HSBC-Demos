package com.trg.jdbc;

import java.sql.*;

class print_columns {
	static Connection conn;
	static Statement stmt;
	static ResultSet rset;

	public static void main(String args[]) throws SQLException {

		String query = "select empno,ename,sal from emp";

		try {

			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oracle", "oracle123");

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();

			int numberOfColumns = rsmd.getColumnCount();

			for (int i = 1; i <= numberOfColumns; i++) {
				if (i > 1)
					System.out.print(", ");
				String columnName = rsmd.getColumnName(i);
				System.out.print(columnName);
			}
			System.out.println("\n-----------------------------");
			while (rset.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					if (i > 1)
						System.out.print(", ");
					String columnValue = rset.getString(i);
					System.out.print(columnValue);
				}
				System.out.print("\n");
			}
		} catch (Exception ex) {
			//System.out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			stmt.close();
			conn.close();
		}
	}
}
