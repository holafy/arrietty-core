package holaivy.comm.file;

import holaivy.comm.log.slf.util.SLU;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FUtil {

	public static void byteToFile(byte[] bytes, String filename)
			throws IOException {
		File file = new File(filename);
		FileOutputStream fos = null;
		FileChannel channel = null;
		try {
			fos = new FileOutputStream(file);
			channel = fos.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
			buffer.put(bytes);
			buffer.flip();
			channel.write(buffer);
			channel.force(false);
		} catch (FileNotFoundException e) {
			SLU.e(e, FUtil.class);
			throw e;
		} catch (IOException e) {
			SLU.e(e, FUtil.class);
			throw e;
		} finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (Exception e) {
				}
			}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
				}
		}
	}

	public static byte[] fileToByteArray2(String filename) throws IOException {
		File f = new File(filename);
		if (!f.exists()) {
			throw new FileNotFoundException(filename);
		}
		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {

			}
			return byteBuffer.array();
		} catch (IOException e) {
			SLU.e(e, FUtil.class);
			throw e;
		} finally {
			try {
				if (channel != null)
					channel.close();
			} catch (IOException e) {
			}
			try {
				if (fs != null)
					fs.close();
			} catch (IOException e) {
			}
		}
	}
}
