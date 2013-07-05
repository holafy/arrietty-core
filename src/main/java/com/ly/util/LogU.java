package com.ly.util;

import org.apache.log4j.Logger;

/**
 * Log 工具类
 * 
 * @author holaivy
 * 
 */
public class LogU {

	public static final String LOGINFO = "ivy.jar";
	public static final Logger logger = Logger.getLogger(LOGINFO);
	protected static final String loggerMessage = "| Caused by :";
	protected static final String exceptionErr = "Exception is null";

	public static void e(Object info) {
		logger.error(info);
	}

	public static void w(Object info) {
		logger.warn(info);
	}

	public static void i(Object info) {
		logger.info(info);
	}

	public static void d(Object info) {
		logger.debug(info);
	}

	public static void d(Logger logger, Exception e) {
		logger.debug(genErrMsg(e));
	}

	public static void e(Logger logger, Exception e) {
		logger.error(genErrMsg(e));
	}

	public static void w(Logger logger, Exception e) {
		logger.warn(genErrMsg(e));
	}

	public static void i(Logger logger, Exception e) {
		logger.info(genErrMsg(e));
	}

	public static void d(Exception e) {
		logger.debug(genErrMsg(e));
	}

	public static void e(Exception e) {
		logger.error(genErrMsg(e));
	}

	public static void i(Exception e) {
		logger.info(genErrMsg(e));
	}

	public static void w(Exception e) {
		logger.warn(genErrMsg(e));
	}

	public static String genErrMsg(Exception e) {
		if (e != null) {
			StringBuilder buf = new StringBuilder();
			buf.append(e.getMessage()).append(loggerMessage).append(e.toString());
			return buf.toString();
		} else
			return exceptionErr;
	}
}
