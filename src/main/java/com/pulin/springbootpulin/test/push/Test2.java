package com.pulin.springbootpulin.test.push;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.pulin.springbootpulin.test.push.deserializer.HashMapDeserializer;
import com.pulin.springbootpulin.test.push.deserializer.LinkedTreeMapDeserializer;
import com.pulin.springbootpulin.test.push.serializer.MapDeserializer;

public class Test2 {
	
	public static void main(String[] args)  throws Exception{
		
		Gson gson = new GsonBuilder()
				
			/*	.registerTypeAdapter(Body.class, new BodySerializer())
				.registerTypeAdapter(Data.class, new DataSerializer())
				.registerTypeAdapter(AvailableTime.class, new AvailableTimeSerializer())
				.registerTypeAdapter(Norm.class, new NormSerializer())
				.registerTypeAdapter(HashMap.class, new HashMapSerializer())
				.registerTypeAdapter(Map.class, new MapSerializer())*/
				
				.registerTypeAdapter(Map.class, new MapDeserializer())
				.registerTypeAdapter(HashMap.class, new HashMapDeserializer())
				//.registerTypeAdapter(TreeMap.class, new TreeMapDeserializer())
				
				.registerTypeAdapter(LinkedTreeMap.class, new LinkedTreeMapDeserializer())
				
				//.registerTypeAdapter(Person.class, new PersonDeserializer())//如何让一个对象中的map转换后int数据类型不转换为double?
				.disableHtmlEscaping()
				.create();
		
		
		String map = "{\"a\":1,\"b\":2,\"c\":{\"aa\":2.0}}";
		Map hashMap = gson.fromJson(map, Map.class);
		
		HashMap ha = new HashMap(hashMap);
		System.out.println(hashMap);
		System.out.println(ha);
		
		/*System.out.println(hashMap.toString());
		System.out.println(gson.toJson(hashMap));*/
		
		/*Map<String,Object> map = new TreeMap<String,Object>();
		map.put("a", 1);
		map.put("b", "2");
		map.put("c", 2.0);
		Map<String,Object> map2 = new TreeMap<String,Object>();
		map2.put("a", 2);
		map2.put("b", 2.0);
		map.put("map", map2);
		
		Person person = new Person();
		person.setMap(map);
		person.setName("pulin");
		String s = gson.toJson(person);
		
		System.out.println(s);
		Person mm = gson.fromJson(s, new TypeToken<Person>(){}.getType());
		mm = gson.fromJson(s, Person.class);
		System.out.println(gson.toJson(mm));*/
		
	}
	
	
	
}
