package com.ly.dbc;

import ivy.basic.ViException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author holaivy@gmail.com
 * 
 */
public abstract class QueryBase implements IQuery {

	protected DBType type = DBType.DefaultDB;

	public DBType getType() {
		return type;
	}

	public void setType(DBType type) {
		this.type = type;
	}

	protected Connection conn = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	protected PreparedStatement ptmt = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neusoft.bi.framework.common.q.IQueryObject#commit()
	 */
	public void commit() throws ViException {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ViException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neusoft.bi.framework.common.q.IQueryObject#rollback()
	 */
	public void rollback() throws ViException {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ViException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neusoft.bi.framework.common.q.IQueryObject#close()
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ptmt != null) {
				ptmt.close();
				ptmt = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		Connection c = null;
		switch (type) {
		case BusinessDB:
			c = Conn.getBusiDBConnection();
			break;
		case DataWarehouse:
			c = Conn.getWareConnection();
			break;
		case SupportDB:
			c = Conn.getSupportDBConn();
			break;
		case DefaultDB:
			c = Conn.getConnection();
		}
		return c;
	}

	public QueryBase(DBType type) {
		super();
		this.type = type;
	}

	public QueryBase() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neusoft.bi.framework.common.q.IQueryObject#setAutoCommit(boolean)
	 */
	public void setAutoCommit(boolean b) throws ViException {
		if (conn != null) {
			try {
				conn.setAutoCommit(b);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ViException(e.getMessage());
			}
		}
	}

}
