package ivy.system;

/**
 * 
 * @author holaivy@gmail.com
 * 
 */
public class SystemConfig {

	private String dbfile = "db.properties";

	private String systemfile = "system.properties";

	public String getDbfile() {
		return dbfile;
	}

	public void setDbfile(String dbfile) {
		this.dbfile = dbfile;
	}

	public String getSystemfile() {
		return systemfile;
	}

	public void setSystemfile(String systemfile) {
		this.systemfile = systemfile;
	}

	public static SystemConfig instance = new SystemConfig();

}
