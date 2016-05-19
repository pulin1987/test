package com.pulin.springbootpulin.test.push.serializer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.pulin.springbootpulin.test.push.Norm;

public class NormSerializer implements JsonSerializer<Norm>{
	@Override
    public JsonElement serialize(Norm obj, Type type, JsonSerializationContext context) {
		    JsonObject object = new JsonObject();
	        TreeMap<String,Object> treemap = new TreeMap<String,Object>();
	        //注意：此处必须按照字母顺序依次加入元素
	        try{
	        	  Field[] field = obj.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
	              for (int j = 0; j < field.length; j++) { //遍历所有属性
	              	 String name = field[j].getName(); //获取属性的名字
	              	 //System.out.println(name);
	                  String  methed_name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
	                   Method m = obj.getClass().getMethod("get" + methed_name);
	                   Object value =  m.invoke(obj); // 调用getter方法获取属性值
	                  // System.out.println(value);
	                   treemap.put(name, value);
	              }
	        }catch(Exception e){
	        	
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
