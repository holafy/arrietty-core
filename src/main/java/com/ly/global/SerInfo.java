package com.ly.global;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.UnknownHostException;

import com.ly.util.LogU;

/**
 * @author holaivy@gmail.com
 * 
 */
public class SerInfo {

	public static String getHost() {
		return hostID;
	}

	private static String hostID = "UNKNOWN_HOST";
	private static SerInfo ins = new SerInfo();

	public SerInfo() {
		super();
		try {
			projectClassURL = this.getClass().getClassLoader().getResource("/");
			if (projectClassURL == null)
				projectClassURL = SerInfo.class.getResource("/");
			if (projectClassURL == null)
				return;
			projectClassDir = new File(projectClassURL.toURI());
			projectClasspath = URLDecoder.decode(projectClassURL.getPath(),
					"utf8");
		} catch (UnsupportedEncodingException e) {
			LogU.e(e.getMessage());
		} catch (URISyntaxException e) {
			LogU.e(e.getMessage());
		}
	}

	private String projectClasspath;
	private File projectClassDir;
	private URL projectClassURL;

	static {
		try {
			hostID = new StringBuilder()
					.append(InetAddress.getLocalHost().getHostName())
					.append("|")
					.append(InetAddress.getLocalHost().getHostAddress())
					.toString();
		} catch (UnknownHostException e) {
			LogU.e(e.getMessage());
		}

	}

	public static String getProjectPath() {
		return ins.projectClasspath;
	}

	public static File getProjectFile() {
		return ins.projectClassDir;
	}

	public static URL getProjectURL() {
		return ins.projectClassURL;
	}
}
