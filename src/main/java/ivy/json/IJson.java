package ivy.json;

import ivy.basic.ViException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.type.TypeReference;

/**
 * @author holaivy
 *
 */
public interface IJson {
	public <T> T decode(String r, Class<T> valueType) throws ViException;

	public <T> T decode(JsonNode j, Class<T> valueType) throws ViException;

	public <T> T decode(JsonNode j, TypeReference<T> valueTypeRef)
			throws ViException;

	public <T> T decode(String r, TypeReference<T> valueTypeRef)
			throws ViException;
}
