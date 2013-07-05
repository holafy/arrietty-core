package ivy.file;

import java.io.File;

/**
 * @author holaivy@gmail.com
 *
 */
public class IvyFile {
	
	public static File fetchAndCreateDir(File parent, String name) {
		File f = new File(parent, name);
		if (!f.exists())
			f.mkdirs();
		return f;
	}

	public static File fetchAndCreateDir(String parent, String name) {
		File f = new File(parent, name);
		if (!f.exists())
			f.mkdirs();
		return f;
	}
}
