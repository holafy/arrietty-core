package ivy.util;

import ivy.basic.ViException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * 读取指定的文件,并转成String
 * 
 * @author holaivy@gmail.com
 * 
 */
public class FetchFileByString {
	
	public static final FetchFileByString instance = new FetchFileByString();
	
	public static final Logger logger = Logger
			.getLogger(FetchFileByString.class);
	
	private StringBuilder buf = new StringBuilder();

	public String read(File file) throws ViException {
		if (file.exists()) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(file));
				String result = null;
				while ((result = reader.readLine()) != null) {
					buf.append(result);
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new ViException(e.getMessage());
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
			return buf.toString();
		}
		throw new ViException("File Not Found!");
	}
}
