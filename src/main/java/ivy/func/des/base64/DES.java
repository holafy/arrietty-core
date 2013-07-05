package ivy.func.des.base64;

import ivy.func.base64.IvyBase64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DES {

	private static String defaultKey = "ZWV766Sv";

	public static String des(String value, String k, int mode) throws Exception {
		byte[] iv = defaultKey.getBytes();
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		SecretKeySpec key = new SecretKeySpec(k.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		byte[] byteMi = null;
		if (mode == Cipher.DECRYPT_MODE) {
			byteMi = IvyBase64.decode(value);
		} else {
			mode = Cipher.ENCRYPT_MODE;
			byteMi = value.getBytes();
		}
		cipher.init(mode, key, zeroIv);
		byte data[] = cipher.doFinal(byteMi);
		if (mode == Cipher.DECRYPT_MODE)
			return new String(data);
		else
			return IvyBase64.encode(data);
	}

	private String key;

	public String encode(String value) throws Exception {
		return des(value, key, Cipher.ENCRYPT_MODE);
	}

	public String decode(String value) throws Exception {
		return des(value, key, Cipher.DECRYPT_MODE);
	}

	public static String encode(String value, String key) throws Exception {
		return des(value, key, Cipher.ENCRYPT_MODE);
	}

	public static String decode(String value, String key) throws Exception {
		return des(value, key, Cipher.DECRYPT_MODE);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}