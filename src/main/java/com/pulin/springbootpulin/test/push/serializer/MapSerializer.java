package com.pulin.springbootpulin.test.push.serializer;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class MapSerializer implements JsonSerializer<Map>{
	@Override
    public JsonElement serialize(Map obj, Type type, JsonSerializationContext context) {
		  JsonObject object = new JsonObject();
	        Map<String,Object> treemap = new HashMap<String,Object>();
	        //注意：此处必须按照字母顺序依次加入元素
	        Iterator<String> obj_iter =  obj.keySet().iterator();
	        while(obj_iter.hasNext()){
		    	  String name =  obj_iter.next();
		    	  Object value = obj.get(name);
		    	  treemap.put(name, value);
		       }
	        
	       Iterator<String> iter =  treemap.keySet().iterator();
	       while(iter.hasNext()){
	    	  String name =  iter.next();
	    	  Object value = treemap.get(name);
	    	  object.add(name, context.serialize(value));
	       }
	      
        
        return object;
    }
}
