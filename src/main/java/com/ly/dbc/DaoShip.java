package com.ly.dbc;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;

/**
 * @author holaivy@gmail.com
 * 
 */
public class DaoShip {

	public static Dao getSupportDao() {
		return new NutDao(DBConnention.getDataSource(DBType.SupportDB));
	}

	public static Dao getBusiDao() {
		return new NutDao(DBConnention.getDataSource(DBType.BusinessDB));
	}

	public static Dao getWareDao() {
		return dao();
	}

	public static Dao dao() {
		return new NutDao(DBConnention.getDataSource(DBType.DataWarehouse));
	}
}
