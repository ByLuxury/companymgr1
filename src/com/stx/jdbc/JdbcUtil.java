package com.stx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Properties props = new Properties();
		/*props.put("user", "stx123");
		props.put("password", "stx123");
		*/
		props.put("user", "root");
		props.put("password", "mysql");

//		props.put("internal_logon", "sysdba");
		return DriverManager.getConnection(
				//"jdbc:oracle:thin:@localhost:1521:orcl", props);
				"jdbc:mysql://localhost:3306/invoice", props);
	}
	
	public static void closeCon(Connection con, Statement st) {
		try {
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
