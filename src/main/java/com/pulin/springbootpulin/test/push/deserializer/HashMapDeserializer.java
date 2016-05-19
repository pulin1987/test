package com.pulin.springbootpulin.test.push.deserializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class HashMapDeserializer implements JsonDeserializer<HashMap>{
		public HashMap deserialize(JsonElement json, java.lang.reflect.Type typeOfT,JsonDeserializationContext context) throws JsonParseException {
		     	HashMap resultMap = new HashMap();
                JsonObject jsonObject = json.getAsJsonObject();
                Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                for (Map.Entry<String, JsonElement> entry : entrySet) {
                    resultMap.put(entry.getKey(),entry.getValue());
                }
                return resultMap;
	}
}

