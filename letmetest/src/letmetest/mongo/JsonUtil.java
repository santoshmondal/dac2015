package letmetest.mongo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.conn.routing.RouteInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JsonUtil {
	public static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		// mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		// mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static Object jsonToObject(String json, String fullyQualifiedClassName) {

		try {
			Class<?> jsonClass = Class.forName(fullyQualifiedClassName);
			return mapper.readValue(json, jsonClass);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object jsonToObject(String json, Class<?> clazz) {

		try {
			return mapper.readValue(json, clazz);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String objectToJson(Object object) {
		try {

			return mapper.writeValueAsString(object);

		}  catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String listObjectToJsonArray(List<?> list) {
		try {
			StringWriter sw = new StringWriter();
			mapper.writeValue(sw, list);

			sw.close();
			return sw.toString();
		}  catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Object jsonArrayToListObject(String json, Class<?> clazz) {
		try {
			return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, clazz));
		}  catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


}
