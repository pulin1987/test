package com.pulin.springbootpulin.test.push.deserializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.pulin.springbootpulin.test.push.serializer.Person;

public class PersonDeserializer implements JsonDeserializer<Person>{
		public  Person deserialize(JsonElement json, java.lang.reflect.Type typeOf,JsonDeserializationContext context) throws JsonParseException {
			System.out.println("json:"+json); 	
			
			Person person = new  Person();
                JsonObject jsonObject = json.getAsJsonObject();
                Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                for (Map.Entry<String, JsonElement> entry : entrySet) {
                	String name = entry.getKey();
                	System.out.println(name);
                	Object value = entry.getValue();
                	System.out.println(value);
                	if(value instanceof HashMap){
                		
                	}
                   
                 /*   try {
                    	 String  methed_name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                    	Field field = person.getClass().getDeclaredField(name);
                    	field.setAccessible(true);
                    	field.set(person, value);
						Method m = person.getClass().getMethod("set" + methed_name);
						m.invoke(person,value);
					} catch (Exception e) {
						e.printStackTrace();
					}*/
                }
                return person;
	}
}

