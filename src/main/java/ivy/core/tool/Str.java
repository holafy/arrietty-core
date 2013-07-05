package ivy.core.tool;

/**
 * String 工具类
 * 
 * @author holaivy@gmail.com
 * 
 */
public class Str {

	/**
	 * 判断String是否为NULL或为空串
	 * 
	 * @param str
	 * @return 为空串或NULL时返回true
	 * 
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 判断String是否不为空
	 * 
	 * @param str
	 * @return 不为空是返回True
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && str.length() > 0;
	}

	/**
	 * 将字符串首字母大写,如果Str为空则直接返回Str
	 * 
	 * @param str
	 * @return
	 */
	public static String upperFirstChar(String str) {
		if (isEmpty(str))
			return str;
		char c = str.charAt(0);
		c = (char) ((c <= 'z' && c >= 'a') ? c - 32 : c);
		return c + str.substring(1);
	}

	/**
	 * 将字符串首字母小写,如果Str为空则直接返回Str
	 * 
	 * @param str
	 * @return
	 */
	public static String lowerFirstChar(String str) {
		if (isEmpty(str))
			return str;
		char c = str.charAt(0);
		c = (char) ((c <= 'Z' && c >= 'A') ? c + 32 : c);
		return c + str.substring(1);
	}

}
