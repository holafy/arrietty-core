package com.ly.dbc;

import ivy.basic.ViException;

import java.util.List;
import java.util.Map;

/**
 * @author holaivy@gmail.com
 * 
 */
public interface IQueryObject extends IQuery {

	public abstract List<Map<String, Object>> queryList(String sql)
			throws ViException;

	public abstract List<Map<String, Object>> queryList(String sql,
			Object[] params) throws ViException;

	public abstract List<Map<String, Object>> queryList(String sql,
			List<Object> params) throws ViException;

	public abstract Map<String, Object> queryMap(String sql) throws ViException;

	public abstract Map<String, Object> queryMap(String sql, Object[] params)
			throws ViException;

	public abstract Map<String, Object> queryMap(String sql, List<Object> params)
			throws ViException;

	public abstract boolean isAutoCommit();

	public abstract void setAutoCommit(boolean autoCommit);

	public abstract boolean isAutoClose();

	public abstract void setAutoClose(boolean autoClose);

}