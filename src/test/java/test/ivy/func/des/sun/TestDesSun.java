package test.ivy.func.des.sun;

import ivy.func.des.sun.DESPlus;

import org.junit.Test;

public class TestDesSun {
	String text = "{\"title\":\"居民医保参保证明\",\"data\":[{\"value\":\"刘伯温\",\"label\":\"姓名\"},{\"value\":\"64455666\",\"label\":\"个人编号\"},{\"value\":\"210600198501011234\",\"label\":\"身份证号\"},{\"value\":\"广州市越秀区民政局\",\"label\":\"所属单位\"},{\"value\":\"本地城镇\",\"label\":\"户口性质\"},{\"value\":\"2012年度(201209-201308)\",\"label\":\"参保年度\"},{\"value\":\"2012-09-19\",\"label\":\"证明日期\"}],\"desc\":null,\"code\":\"0001\"}";

	@Test
	public void test() {
		try {
			DESPlus des = new DESPlus("wgZIiqbyADn2ZWV766Sv");
			String result1=des.encrypt(text);
			String result2= des.decrypt(result1);
			System.out.println("加密后:"+ result1);
			System.out.println("解密后:"+ result2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
