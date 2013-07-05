package ivy.system;

import ivy.core.tool.Str;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.nutz.lang.Strings;

import com.ly.global.SerInfo;
import com.ly.util.LogU;

/**
 * @author holaivy@gmail.com
 * 
 */
public class SysInfo {

	private static final Logger logger = Logger.getLogger(SysInfo.class);

	private boolean dev;
	private String store;

	public File fetchStoreFileDir() {
		if (Strings.isEmpty(store)) {
			return new File("");
		}
		return new File(store);
	}

	/**
	 * 获取Store文件夹下的子文件夹
	 * 
	 * @param name
	 * @return
	 */
	public File fetchChildDir(String name) {
		File f = null;
		if (Str.isEmpty(store)) {
			f = new File(".", name);
			logger.warn("System Store value is null");
		} else
			f = new File(store, name);
		if (!f.exists())
			if (!f.mkdirs()) {
				logger.error("Create dir [" + name + "] failed.");
			}
		return f;

	}

	public boolean isDev() {
		return dev;
	}

	public void setDev(boolean dev) {
		this.dev = dev;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public static boolean read() {
		Properties p = new Properties();
		File file = new File(SerInfo.getProjectPath(),
				SystemConfig.instance.getSystemfile());
		if (file.exists()) {
			FileInputStream in = null;
			if (logger.isDebugEnabled())
				logger.debug("Ready to read system properties file : "
						+ file.toString());
			try {
				in = new FileInputStream(file);
				p.load(in);
				String k = "dev";
				instance.dev = Boolean.valueOf(p.getProperty(k, "true"));
				k = "store";
				instance.store = p.getProperty(k, "");
				if (logger.isDebugEnabled())
					logger.debug("SysInfo : dev" + instance.dev + " , store:"
							+ instance.store);
				return true;
			} catch (FileNotFoundException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			} finally {
				if (in != null)
					try {
						in.close();
					} catch (IOException e) {
						logger.error(e.getMessage());
					}
			}

		} else {
			logger.error(SystemConfig.instance.getSystemfile()
					+ " is not found!");
		}
		return false;
	}

	public static boolean write() {
		Properties p = new Properties();
		File file = new File(SerInfo.getProjectPath(),
				SystemConfig.instance.getSystemfile());
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			if (logger.isDebugEnabled())
				logger.debug("Ready to write system properties file : "
						+ file.toString());
			p.setProperty("dev", String.valueOf(SysInfo.instance.dev));
			p.setProperty("store", SysInfo.instance.store);
			p.store(out, new Date().toString());
			return true;
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
		}
		return false;
	}

	public static SysInfo instance = new SysInfo();

	static {
		read();
	}
}
