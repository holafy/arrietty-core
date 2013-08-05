package holaivy.comm.log.slf.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ly.util.LogU;

/**
 * slf4j log util
 * 
 * @author holaivy@gmail.com
 * 
 */
public class SLU {

	public static final Logger logger = LoggerFactory.getLogger(LogU.LOGINFO);
	public static final String ERR_OUT_FORMAT = "[{}] CAUSED BY [{}]";

	public static void err(Logger lgr, Exception e) {
		lgr.error(ERR_OUT_FORMAT, e.toString(), e.getMessage());
	}

	public static void e(Object e) {
		h(e, null, SLUType.Error);
	}

	public static void e(Object e, Object tag) {
		h(e, tag, SLUType.Error);
	}

	public static void w(Object e) {
		h(e, null, SLUType.Warn);
	}

	public static void w(Object e, Object tag) {
		h(e, tag, SLUType.Warn);
	}

	public static void i(Object e) {
		h(e, null, SLUType.Info);
	}

	public static void i(Object e, Object tag) {
		h(e, tag, SLUType.Info);
	}

	public static void d(Object e) {
		h(e, null, SLUType.Debug);
	}

	public static void d(Object e, Object tag) {
		h(e, tag, SLUType.Debug);
	}

	protected static void h(Object e, Object tag, SLUType type) {
		if (e instanceof Exception) {
			Exception ex = (Exception) e;
			output(tag == null ? "" : tag.toString(), ex.toString(),
					ex.getMessage(), type);
		} else if (e instanceof String) {
			output(tag == null ? "" : tag.toString(), e.toString(), type);
		}
	}

	protected static void output(String tag, String e, SLUType type) {
		String logerr = "[{}] : [{}] ";
		switch (type) {
		case Debug:
			logger.debug(logerr, tag, e);
			break;
		case Error:
			logger.error(logerr, tag, e);
			break;
		case Info:
			logger.info(logerr, tag, e);
			break;
		case Warn:
			logger.warn(logerr, tag, e);
			break;
		}
	}

	protected static void output(String tag, String e, String em, SLUType type) {
		String logerr = "[{}] : [{}] CAUSED BY [{}]";
		switch (type) {
		case Debug:
			logger.debug(logerr, tag, e, em);
			break;
		case Error:
			logger.error(logerr, tag, e, em);
			break;
		case Info:
			logger.info(logerr, tag, e, em);
			break;
		case Warn:
			logger.warn(logerr, tag, e, em);
			break;
		}
	}

}
