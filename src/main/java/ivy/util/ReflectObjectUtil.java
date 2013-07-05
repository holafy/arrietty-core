package ivy.util;

/**
 * 反射对象工具类
 * 
 * @author holaivy@gmail.com
 * 
 */
public class ReflectObjectUtil {

	/**
	 * 判断方法名字是否是GETTER方法.
	 * 
	 * @param methodName
	 * @return -1 不是 ,1-get方法,2-is方法
	 * 
	 */
	public static GetterMethodTag isGetterMethod(String methodName) {
		if (methodName != null && methodName.length() > 3) {
			if (methodName.startsWith("get")) {
				if (methodName.length() >= 4) {
					char c = methodName.charAt(3);
					if ((c < 'Z' && c > 'A') || c == '_') {
						return GetterMethodTag.Yes_Get;
					}
				}
			} else if (methodName.startsWith("is")) {
				char c = methodName.charAt(3);
				if ((c < 'Z' && c > 'A') || c == '_') {
					return GetterMethodTag.Yes_Is;
				}
			}
		}
		return GetterMethodTag.No;
	}

	/**
	 * Getter 方法枚举
	 * 
	 * @author holaivy@gmail.com
	 * 
	 */
	public static enum GetterMethodTag {
		No, Yes_Get, Yes_Is;
	}
}
