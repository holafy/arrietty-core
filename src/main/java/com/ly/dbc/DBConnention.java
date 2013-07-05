package com.ly.dbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author holaivy@gmail.com
 * 
 */
public class DBConnention {

	protected static Map<DBInfo, DataSource> pool = new HashMap<DBInfo, DataSource>();

	static {
		pool.put(DBInfo.BusiDBInfo, getDataSource(DBInfo.BusiDBInfo, false));
		pool.put(DBInfo.DataWarehouseInfo,
				getDataSource(DBInfo.DataWarehouseInfo, false));
		pool.put(DBInfo.SupportDBInfo,
				getDataSource(DBInfo.SupportDBInfo, false));
	}

	public static DataSource getDefaultDataSource() {
		return getDataSource(DBType.DataWarehouse);
	}

	public static DataSource getDataSource(DBType type) {
		return getDataSource(type, false);
	}

	/**
	 * @param type
	 * @param autocommit
	 * @return
	 */
	public static DataSource getDataSource(DBType type, boolean autocommit) {
		DBInfo db = null;
		switch (type) {
		case BusinessDB:
			db = DBInfo.BusiDBInfo;
			break;
		case DataWarehouse:
		case DefaultDB:
			db = DBInfo.DataWarehouseInfo;
			break;
		case SupportDB:
		default:
			db = DBInfo.SupportDBInfo;
			break;
		}
		return pool.get(db);

	}

	public static DataSource getDataSource(String driver, String url,
			String user, String pass, boolean autocommit) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pass);
		ds.setDefaultAutoCommit(autocommit);
		return ds;
	}

	public static DataSource getDataSource(DBInfo db, boolean autocommit) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(db.driver);
		ds.setUrl(db.url);
		ds.setUsername(db.username);
		ds.setPassword(db.password);
		ds.setDefaultAutoCommit(autocommit);
		return ds;
	}

}
