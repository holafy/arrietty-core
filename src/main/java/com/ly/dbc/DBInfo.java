package com.ly.dbc;

import ivy.system.SystemConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import com.ly.global.SerInfo;
import com.ly.util.LogU;

/**
 * 用于存放数据库连接信息
 * 
 * @author holaivy@gmail.com
 * 
 */
public class DBInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6430975795913809996L;
	public static DBInfo BusiDBInfo = new DBInfo("业务库");
	public static DBInfo SupportDBInfo = new DBInfo("支撑库");
	public static DBInfo DataWarehouseInfo = new DBInfo("默认数据库/数据仓库");

	public static String appPropertyFilePath = SystemConfig.instance
			.getDbfile();

	static {
		initDataBaseInfo();
	}

	/**
	 * 初始化默认的DataBase信息
	 */
	public static void initDataBaseInfo() {
		File f = new File(SerInfo.getProjectPath(), appPropertyFilePath);
		if (f.exists())
			rebuild(f);
	}

	static void buidDatabaseInfo(StringBuilder buf, DBInfo info) {
		if (!info.empty()) {
			buf.append("\n").append(info);
			buf.append(" info load! ->\ndriver:").append(
					DataWarehouseInfo.driver);
			buf.append("\nurl:").append(DataWarehouseInfo.url)
					.append("\nusername:").append(DataWarehouseInfo.username);
		} else
			buf.append("\n").append(info).append(" Info is Empty");
	}

	/**
	 * 构建DataBase信息
	 * 
	 * @param file
	 */
	public static void rebuild(File file) {
		Properties p = new Properties();
		FileInputStream in = null;
		if (file == null || !file.exists()) {
			LogU.w("DBInfo Waring : db file :" + file.toString()
					+ " is not found");
			return;
		}
		StringBuilder buf = new StringBuilder();
		buf.append("\nOutput database info ready.");
		try {
			p.load(in = new FileInputStream(file));
			DataWarehouseInfo.driver = p.getProperty("jdbc.driver");
			DataWarehouseInfo.url = p.getProperty("jdbc.url");
			DataWarehouseInfo.username = p.getProperty("jdbc.username");
			DataWarehouseInfo.password = p.getProperty("jdbc.password");
			buidDatabaseInfo(buf, DataWarehouseInfo);
			BusiDBInfo.driver = p.getProperty("bjdbc.driver");
			BusiDBInfo.url = p.getProperty("bjdbc.url");
			BusiDBInfo.username = p.getProperty("bjdbc.username");
			BusiDBInfo.password = p.getProperty("bjdbc.password");
			buidDatabaseInfo(buf, BusiDBInfo);
			SupportDBInfo.driver = p.getProperty("sjdbc.driver");
			SupportDBInfo.url = p.getProperty("sjdbc.url");
			SupportDBInfo.username = p.getProperty("sjdbc.username");
			SupportDBInfo.password = p.getProperty("sjdbc.password");
			buidDatabaseInfo(buf, SupportDBInfo);
			buf.append("\nOutput database info end.");
		} catch (FileNotFoundException e) {
			LogU.e(e.getMessage());
		} catch (IOException e) {
			LogU.e(e.getMessage());
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					LogU.e(e.getMessage());
				}
			LogU.d(buf.toString());
		}
	}

	public String url;
	public String password;
	public String username;
	public String driver;
	public String name;

	/**
	 * Is the DataBase info is empty
	 * 
	 * @return
	 */
	public boolean empty() {
		return url == null || url.length() == 0 || username == null
				|| username.length() == 0;
	}

	public DBInfo() {
		super();
	}

	public DBInfo(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return name == null ? "NoName" : name;
	}

}
