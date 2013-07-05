package test.ivy.core.tool;

import static org.junit.Assert.*;
import ivy.core.tool.Str;

import org.junit.Test;

public class TestStr {

	@Test
	public void testLower() {
		String source = "Found";
		String dest = "found";
		String result = Str.lowerFirstChar(source);
		assertEquals(result, dest);
	}

	@Test
	public void testUpper() {
		String source = "found";
		String dest = "Found";
		assertEquals(Str.upperFirstChar(source), dest);
	}

	@Test
	public void testUpperWithSingleChar() {
		String source = "f";
		String dest = "F";
		assertEquals(Str.upperFirstChar(source), dest);
	}

}
