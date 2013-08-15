package test.holaivy.file;

import holaivy.comm.file.FUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ly.global.SerInfo;

public class FileUtilTest {

	public static final String target = "efines in what format to expect the data that fills the grid. Valid options are xml (we expect data in xml format), xmlstring (we expect xml data as string), json (we expect data in JSON format), jsonstring (we expect JSON data as a string), local (we expect data defined at client side (array data)), javascript (we expect javascript as data), function (custom defined function for retrieving data), ";
	private File file;
	private File tempFile;

	@Before
	public void before() {
		file = new File(SerInfo.getProjectFile(), "test/file/0.jpg");
		tempFile = new File(SerInfo.getProjectFile(), "test/temp/temp.txt");
	}

	@Test
	public void testWrite() {
		try {
			Charset charset = Charset.forName("UTF8");
			byte[] source = target.getBytes(charset);
			FUtil.byteToFile(source, tempFile.toString());
			byte[] bytes = FUtil.fileToByteArray2(tempFile.toString());
			Assert.assertArrayEquals("读写不相符", bytes, source);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRead() {
		try {
			byte[] bytes = FUtil.fileToByteArray2(file.toString());
			Assert.assertTrue(bytes.length > 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
