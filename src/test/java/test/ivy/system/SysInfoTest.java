package test.ivy.system;

import ivy.system.SysInfo;

import org.junit.Assert;
import org.junit.Test;

public class SysInfoTest {

	@Test
	public void read() {
		Assert.assertTrue(SysInfo.read());
		System.out.println(SysInfo.instance.isDev());
		System.out.println(SysInfo.instance.getStore());
	}

	@Test
	public void write() {
		Assert.assertTrue(SysInfo.write());
	}
}
