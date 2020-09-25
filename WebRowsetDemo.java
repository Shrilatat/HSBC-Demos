package com.trg.jdbc;

import java.io.StringWriter;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowsetDemo {
	public static void main(String[] args) {
		WebRowSet rs = null;
		try {
			RowSetFactory factory = RowSetProvider.newFactory();
			rs = factory.createWebRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			rs.setUsername("oracle");
			rs.setPassword("oracle123");
			rs.setCommand("select * from employee");
			rs.execute();
			// Create a StringWriter object to hold the exported XML
			StringWriter sw = new StringWriter();
			// Write the XML representation of webRs into sw
			rs.writeXml(sw);
			// Get the String object from sw
			String webRsXML = sw.toString();
			// Print the exported XML from the WebRowSet
			System.out.println(webRsXML);
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
