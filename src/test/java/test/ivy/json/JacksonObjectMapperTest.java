package test.ivy.json;

import static org.junit.Assert.*;
import ivy.basic.ViException;
import ivy.json.Json;

import org.junit.Test;

public class JacksonObjectMapperTest {

	@Test
	public void test() {
		JacksonData data= new JacksonData();
		data.setName("xbc@163.com");
		try {
			System.out.println(Json.encode(data));
		} catch (ViException e) {
			e.printStackTrace();
		}
	}

}
