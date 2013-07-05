package com.ly.dbc;

import ivy.basic.ViException;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ly.util.LogU;

/**
 * @author holaivy@gmail.com
 * 
 */
public class QueryObject extends QueryBase implements IQueryObject {

	public QueryObject() {
		super();
	}

	public QueryObject(DBType type) {
		super(type);
	}

	private boolean caseLock = true;

	public boolean isCaseLock() {
		return caseLock;
	}

	public void setCaseLock(boolean caseLock) {
		this.caseLock = caseLock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neusoft.bi.framework.common.q.IQueryObject#queryList(java.lang.String
	 * )
	 */
	public List<Map<String, Object>> queryList(String sql) throws ViException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			conn = getConnection();
			conn.setAutoCommit(autoCommit);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			LogU.d(sql);
			Map<String, Object> map = null;
			ResultSetMetaData meta = rs.getMetaData();
			int columnsize = meta.getColumnCount();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				for (int i = 1; i <= columnsize; i++)
					map.put(caseLock ? meta.getColumnLabel(i) : meta
							.getColumnLabel(i).toLowerCase(), rs.getObject(i));
				list.add(map);
			}
			map = null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ViException(e.getMessage());
		} finally {
			if (autoClose)
				close();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neusoft.bi.framework.common.q.IQueryObject#queryList(java.lang.String
	 * , java.lang.Object[])
	 */
	public List<Map<String, Object>> queryList(String sql, Object[] params)
			throws ViException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			conn = getConnection();
			conn.setAutoCommit(autoCommit);
			ptmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++)
				ptmt.setObject(i + 1, params[i]);
			LogU.d(sql);
			LogU.d("\t-->params:" + params.toString());
			rs = ptmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			int columnsize = meta.getColumnCount();
			Map<String, Object> map = null;
			while (rs.next()) {
				map = new HashMap<String, Object>();
				for (int i = 1; i <= columnsize; i++)
					map.put(caseLock ? meta.getColumnLabel(i) : meta
							.getColumnLabel(i).toLowerCase(), rs.getObject(i));
				list.add(map);
			}
			map = null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ViException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ViException(e.getMessage());
		} finally {
			if (autoClose)
				close();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neusoft.bi.framework.common.q.IQueryObject#queryList(java.lang.String
	 * , java.util.List)
	 */
	public List<Map<String, Object>> queryList(String sql, List<Object> params)
			throws ViException {
		return queryList(sql, params.toArray());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neusoft.bi.framework.common.q.IQueryObject#queryMap(java.lang.String)
	 */
	public Map<String, Object> queryMap(String sql) throws ViException {
		return queryList(sql).get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neusoft.bi.framework.common.q.IQueryObject#queryMap(java.lang.String,
	 * java.lang.Object[])
	 */
	public Map<String, Object> queryMap(String sql, Object[] params)
			throws ViException {
		return queryList(sql, params).get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neusoft.bi.framework.common.q.IQueryObject#queryMap(java.lang.String,
	 * java.util.List)
	 */
	public Map<String, Object> queryMap(String sql, List<Object> params)
			throws ViException {
		return queryMap(sql, params.toArray());
	}

	private boolean autoCommit = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neusoft.bi.framework.common.q.IQueryObject#isAutoCommit()
	 */
	public boolean isAutoCommit() {
		return autoCommit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neusoft.bi.framework.common.q.IQueryObject#setAutoCommit(boolean)
	 */
	public void setAutoCommit(boolean autoCommit) {
		this.autoCommit = autoCommit;
	}

	private boolean autoClose = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neusoft.bi.framework.common.q.IQueryObject#isAutoClose()
	 */
	public boolean isAutoClose() {
		return autoClose;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neusoft.bi.framework.common.q.IQueryObject#setAutoClose(boolean)
	 */
	public void setAutoClose(boolean autoClose) {
		this.autoClose = autoClose;
	}

}
