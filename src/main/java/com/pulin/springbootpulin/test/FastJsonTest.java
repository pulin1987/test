package com.pulin.springbootpulin.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonTest {
	public static void main(String[] args) throws Exception {

		//System.out.println(JSON.toJSONString(new Person()));
		
		
		Map map = new HashMap();
		map.put("c", "c");
		map.put("b", "b");
		map.put("a", "a");
		map.put("null2", null);
		
		Map map2 = new HashMap();
		map2.put("c", "c");
		map2.put("b", "b");
		map2.put("a", "a");
		
		map.put("d", map2);
		
		map.put("z", new HashMap());
		map.put("y", new ArrayList());
		map.put("person", new Person());
		
/*	    int features = 0;
        features |= SerializerFeature.QuoteFieldNames.getMask();
        features |= SerializerFeature.SkipTransientField.getMask();
        features |= SerializerFeature.WriteEnumUsingName.getMask();
        //features |= SerializerFeature.SortField.getMask();
        System.out.println(features);
		JSON.DEFAULT_GENERATE_FEATURE=features;
		
		
	    int features2 = 0;
	    features2 |= Feature.AutoCloseSource.getMask();
	    features2 |= Feature.InternFieldNames.getMask();
	    features2 |= Feature.UseBigDecimal.getMask();
	    features2 |= Feature.AllowUnQuotedFieldNames.getMask();
	    features2 |= Feature.AllowSingleQuotes.getMask();
	    features2 |= Feature.AllowArbitraryCommas.getMask();
	   // features2 |= Feature.SortFeidFastMatch.getMask();
	    features2 |= Feature.IgnoreNotMatch.getMask();
	    System.out.println(features2);
        JSON.DEFAULT_PARSER_FEATURE = features2;*/
		
		
		
/*		QuoteFieldNames———-输出key时是否使用双引号,默认为true 
		WriteMapNullValue——–是否输出值为null的字段,默认为false 
		WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null 
		WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null 
		WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null 
		WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null*/
        
        
		//System.out.println(JSON.toJSONString(map,SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue));
		
/*		long s=System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			JSON.toJSONString(new Person(),SerializerFeature.UseSingleQuotes);
		}
		long e=System.currentTimeMillis();
		System.out.println(e-s);*/
		
		   SerializeWriter out = new SerializeWriter();
		   String json = null;
	        try {
	            JSONSerializer serializer = new JSONSerializer(out);
	            serializer.config(SerializerFeature.PrettyFormat, true);
	            serializer.config(SerializerFeature.QuoteFieldNames, true);
	            serializer.config(SerializerFeature.UseSingleQuotes, false);
	            serializer.config(SerializerFeature.SortField, false);
	            serializer.config(SerializerFeature.WriteMapNullValue, false);
	            serializer.config(SerializerFeature.WriteNullStringAsEmpty, false);
	            Person person = new Person();
	            person.setSign(null);
	            serializer.write(person);
	            json = out.toString();
	            System.out.println(json);
	        } finally {
	            out.close();
	        }
	        
	        //System.out.println(UUID.randomUUID().toString().toUpperCase());
	        
	        System.out.println(JSON.parse(json));
	        JSON.parseObject(json);

	}
	
	
	
	@JSONType(asm=true)
	public static class Person{
		
		@JSONField(name="name")
		private String name = "plly";
		
		@JSONField(name="age")
		private String age = "29";
		
		@JSONField (format="yyyy-MM-dd HH:mm:ss")
		private Date date = new Date();
		
		//@JSONField(name="abc",serialzeFeatures={SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty})
		private String abc;
		
		//@JSONField(name="map",serialzeFeatures={SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty})
		private HashMap map;
		
		private String sign = UUID.randomUUID().toString().toUpperCase();
		
		private Car car = new Car();
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getAbc() {
			return abc;
		}
		public void setAbc(String abc) {
			this.abc = abc;
		}
		public HashMap getMap() {
			return map;
		}
		public void setMap(HashMap map) {
			this.map = map;
		}
		public Car getCar() {
			return car;
		}
		public void setCar(Car car) {
			this.car = car;
		}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
	}
	
	public static class Car{
		private String name="tongyong";
		private String color="write";
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
	}

}
