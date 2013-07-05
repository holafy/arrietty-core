package ivy.util;

import ivy.util.ReflectObjectUtil.GetterMethodTag;

import java.lang.reflect.Method;

import com.ly.util.LogU;

/**
 * @author holaivy@gmail.com
 * 
 */
public class ObjUtil {

	/**
	 * 返回Object对象Getter方法的名字和值,仅适用于Debug用途
	 * 
	 * @param obj
	 *            对象为NULL,将返回 Object is NULL 信息
	 * @return
	 */
	public static String outputObjectValue(Object obj) {
		if (obj == null)
			return "Object is NULL!";
		StringBuilder buf = new StringBuilder();
		Class<? extends Object> cls = obj.getClass();
		Method[] ms = cls.getDeclaredMethods();
		for (Method m : ms) {
			String mName = m.getName();
			GetterMethodTag rValue = ReflectObjectUtil.isGetterMethod(mName);
			if (rValue != GetterMethodTag.No) {
				Object o = null;
				try {
					o = m.invoke(obj, new Object[] {});
					String propertyName = mName
							.substring(rValue == GetterMethodTag.Yes_Get ? 3
									: 2);
					buf.append("Method: ").append(propertyName);
					buf.append("\n");
					buf.append("Value: ")
							.append(o == null ? "NULL" : o.toString())
							.append("\n");
				} catch (Exception e) {
					LogU.e(e);
				}
			}
		}
		return buf.toString();
	}
}
