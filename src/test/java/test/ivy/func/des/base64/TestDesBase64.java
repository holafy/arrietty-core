package test.ivy.func.des.base64;

import ivy.func.des.base64.DES;

import org.junit.Test;

/**
 * @author holaivy@gmail.com
 * 
 */
public class TestDesBase64 {

	@Test
	public void test() {
		String key = "wgZIiqby";
		String text = "{\"c\":\"0001\",\"t\":\"居民医保参保证明\",\"d\":null,\"f\":[{\"l\":\"姓名\",\"v\":\"刘伯温\"},{\"l\":\"个人编号\",\"v\":\"64455666\"},{\"l\":\"身份证号\",\"v\":\"210600198501011234\"},{\"l\":\"所属单位\",\"v\":\"广州市越秀区民政局\"},{\"l\":\"户口性质\",\"v\":\"本地城镇\"},{\"l\":\"参保年度\",\"v\":\"2012年度(201209-201308)\"},{\"l\":\"证明日期\",\"v\":\"2012-09-19\"}]}";
		String result1 = null;
		String result2 = null;
		try {
			result1 = DES.encode(text, key);
			result2 = DES.decode(result1, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("加密结果:" + result1);
		System.out.println("解密结果:" + result2);
	}
}
