package com.pulin.springbootpulin.test.push.deserializer;

import java.util.Map;
import java.util.Set;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.internal.LinkedTreeMap;

public class LinkedTreeMapDeserializer implements JsonDeserializer<LinkedTreeMap>{
		public LinkedTreeMap deserialize(JsonElement json, java.lang.reflect.Type typeOfT,JsonDeserializationContext context) throws JsonParseException {
			LinkedTreeMap resultMap = new LinkedTreeMap();
                JsonObject jsonObject = json.getAsJsonObject();
                Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                for (Map.Entry<String, JsonElement> entry : entrySet) {
                    resultMap.put(entry.getKey(),entry.getValue());
                }
                return resultMap;
	}
}

