package com.ly.dbc;

import ivy.basic.ViException;

/**
 * @author holaivy@gmail.com
 *
 */
public interface IQuery {

	public abstract DBType getType();

	public abstract void setType(DBType type);

	/**
	 * 提交
	 * 
	 * @throws BIException
	 */
	public abstract void commit() throws ViException;

	/**
	 * 回滚
	 * 
	 * @throws BIException
	 */
	public abstract void rollback() throws ViException;

	/**
	 * 关闭连接
	 */
	public abstract void close();

	/**
	 * 设置是否自动提交
	 * 
	 * @param b
	 * @throws BIException
	 */
	public abstract void setAutoCommit(boolean b) throws ViException;

}