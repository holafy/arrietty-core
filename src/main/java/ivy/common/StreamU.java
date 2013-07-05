package ivy.common;

import ivy.basic.ViException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

/**
 * 流工具
 * 
 * @author holaivy@gmail.com
 * 
 */
public class StreamU {

	/**
	 * 将Input流写入到Outpout流中直至结束, 并关闭流
	 * 
	 * @param in
	 * @param out
	 * @return true为成功,反之失败.
	 * @throws ViException
	 */
	public static boolean stream(InputStream in, OutputStream out)
			throws ViException {
		return write(in, out, true);
	}

	/**
	 * 将Input流写入到Outpout流中,并且不会关闭流,流交由调用者自行处理
	 * 
	 * @param in
	 * @param out
	 * @return true为成功,反之失败.
	 * @throws ViException
	 */
	public static boolean writeStreamWithoutClose(InputStream in,
			OutputStream out) throws ViException {
		return write(in, out, false);
	}

	protected static boolean write(InputStream in, OutputStream out,
			boolean close) throws ViException {
		if (in != null && out != null) {
			try {
				byte[] b = new byte[1024];
				int len = 0;
				while ((len = in.read(b)) > 0) {
					out.write(b, 0, len);
				}
				out.flush();
				return true;
			} catch (Exception e) {
				Logger.getLogger(StreamU.class).debug(e.getMessage());
				throw new ViException(e.getMessage());
			} finally {
				if (close) {
					if (in != null)
						try {
							in.close();
						} catch (IOException e) {
							Logger.getLogger(StreamU.class).debug(
									e.getMessage());
						}
					if (out != null)
						try {
							out.close();
						} catch (IOException e) {
							Logger.getLogger(StreamU.class).debug(
									e.getMessage());
						}
				}
			}
		}
		return false;
	}

}
