package com.ly.dbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author holaivy@gmail.com
 * 
 */
public class Conn {

	public static Connection getWareConnection() throws SQLException {
		return getConnection();
	}

	public static Connection getConnection() throws SQLException {
		return DBConnention.getDefaultDataSource().getConnection();
	}

	public static Connection getBusiDBConnection() throws SQLException {
		return DBConnention.getDataSource(DBType.BusinessDB).getConnection();
	}

	public static Connection getSupportDBConn() throws SQLException {
		return DBConnention.getDataSource(DBType.SupportDB).getConnection();
	}

}
