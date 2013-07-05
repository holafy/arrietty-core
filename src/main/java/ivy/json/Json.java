package ivy.json;

import ivy.basic.ViException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.TypeReference;

/**
 * Json 工具类, 使用JackSon工具类
 * 
 * @author holaivy
 * 
 */
public class Json {

	/**
	 * 全局ObjectMapper
	 */
	public static ObjectMapper om = new ObjectMapper();
	
	static {
		try {
			om.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
//			om.setSerializationInclusion(Inclusion.NON_NULL);
			om.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
		} catch (Exception e) {
		}
	}

	/**
	 * 将Object对象输出成JSON 字符串
	 * 
	 * @param value
	 * @return
	 * @throws ViException
	 */
	public static String encode(Object value) throws ViException {
		try {
			return om.writeValueAsString(value);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

	/**
	 * 将JSON字符串转换成Object对象
	 * 
	 * @param r
	 * @param valueType
	 * @return
	 * @throws ViException
	 */
	public static <T> T decode(String r, Class<T> valueType) throws ViException {
		try {
			return om.readValue(r, valueType);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

	public static <T> T decode(JsonNode j, Class<T> valueType)
			throws ViException {
		try {
			return om.readValue(j, valueType);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T decode(JsonNode j, TypeReference<T> valueTypeRef)
			throws ViException {
		try {
			return (T) om.readValue(j, valueTypeRef);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T decode(String r, TypeReference<T> valueTypeRef)
			throws ViException {
		try {
			return (T) om.readValue(r, valueTypeRef);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}
}
