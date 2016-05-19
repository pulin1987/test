package com.pulin.springbootpulin.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.pulin.springbootpulin.utils.Cmd;
import com.pulin.springbootpulin.utils.EncryptUtils;

public class BaiduwaimaiOrderCreateSignTest {
	
	public static void main(String[] args)  throws Exception{
		treemap();
		//hashmap();
	}
	
	public static void treemap()  throws Exception{

		
		TreeMap<String, Object> map = new TreeMap<String,Object>();
		map.put("cmd", "order.create");
		map.put("timestamp", 1458294106); 
		map.put("version", "2.0");
		map.put("ticket", "46834D6C-9AB1-D478-CE70-9702119643E8");
		map.put("source", "65487");
		map.put("secret", "85bff21a43cb8da6");
		
		//1
		TreeMap<String, Object> body = new TreeMap<String,Object>();
		body.put("source", "65487");
		
		//2
		TreeMap<String, Object> shop = new TreeMap<String,Object>();
		shop.put("id", "247900001");
		shop.put("name", "客如云测试");
		shop.put("baidu_shop_id", "1486061032");
		
		body.put("shop", shop);
		
		
		TreeMap<String, Object> order = new TreeMap<String,Object>();
		order.put("order_id", "14582941023134");
		order.put("send_immediately", 1);
		order.put("send_time", "1");
		order.put("send_fee", 0);
		order.put("package_fee", 0);
		order.put("discount_fee", 0);
		order.put("total_fee", 1);
		order.put("shop_fee", 1);
		order.put("user_fee", 1);
		order.put("pay_type", 1);
		order.put("pay_status", 1);
		order.put("need_invoice", 1);
		order.put("invoice_title", "发票信息0001");
		order.put("remark", "请提供餐具,辣一点");
		order.put("delivery_party", 2);
		order.put("create_time", "1458294102");
		
		body.put("order", order);
		
		
		//3
		TreeMap<String, Object> user = new TreeMap<String,Object>();
		user.put("name", "pan");
		user.put("phone", "13608050511");
		user.put("gender", 1);
		user.put("address", "首都体育馆南路");
		TreeMap<String, Object> coord = new TreeMap<String,Object>();
		coord.put("longitude", 116.332561);
		coord.put("latitude", 39.929333);
		user.put("coord", coord);
		
		body.put("user", user);
		
		
		//4
		List<TreeMap<String, Object>> productList = new ArrayList<TreeMap<String, Object>>();
		TreeMap<String, Object> product = new TreeMap<String,Object>();
		product.put("product_id", "13934");
		product.put("upc", "");
		product.put("product_name", "麻婆豆腐");
		product.put("product_price", 1);
		product.put("product_amount", 1);
		product.put("product_fee", 1);
		product.put("package_price", 0);
		product.put("package_amount", "1");
		product.put("package_fee", 0);
		product.put("total_fee", 1);
		productList.add(product);
		
		body.put("products", productList);
		
		//5
		List<TreeMap<String, Object>> discount = new ArrayList<TreeMap<String, Object>>();
		body.put("discount", discount);
		
		
		
		map.put("body", body);
		
		
		
		String json = new Gson().toJson(map);
		json = Cmd.chinaToUnicode(json);
		json = Cmd.chinaToUnicode(json);
		System.out.println("treemap:"+json);
		System.out.println(Cmd.getSign(map));

	
	}
	
	
	
	
	
	
	public static void hashmap()  throws Exception{

		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("cmd", "order.create");
		map.put("timestamp", 1458135410); 
		map.put("version", "2.0");
		map.put("ticket", "3A487A6C-D2EC-46E2-3338-D576060D60DD");
		map.put("source", "65487");
		map.put("secret", "85bff21a43cb8da6");
		
		//1
		HashMap<String, Object> body = new HashMap<String,Object>();
		body.put("source", "65487");
		
		//2
		HashMap<String, Object> shop = new HashMap<String,Object>();
		shop.put("id", "247900001");
		shop.put("name", "客如云测试");
		shop.put("baidu_shop_id", "1486061032");
		
		body.put("shop", shop);
		
		
		HashMap<String, Object> order = new HashMap<String,Object>();
		order.put("order_id", "14581354068558");
		order.put("send_immediately", 1);
		order.put("send_time", "1");
		order.put("send_fee", 100);
		order.put("package_fee", 100);
		order.put("discount_fee", 0);
		order.put("total_fee", 203);
		order.put("shop_fee", 203);
		order.put("user_fee", 203);
		order.put("pay_type", 1);
		order.put("pay_status", 1);
		order.put("need_invoice", 2);
		order.put("invoice_title", "");
		order.put("remark", "请提供餐具,不吃辣");
		order.put("delivery_party", 2);
		order.put("create_time", "1458135407");
		
		body.put("order", order);
		
		
		//3
		HashMap<String, Object> user = new HashMap<String,Object>();
		user.put("name", "bao");
		user.put("phone", "15832222222");
		user.put("gender", 1);
		user.put("address", "中国国家图書馆 1楼101");
		HashMap<String, Object> coord = new HashMap<String,Object>();
		coord.put("longitude", 116.331404);
		coord.put("latitude", 39.948952);
		user.put("coord", coord);
		
		body.put("user", user);
		
		
		//4
		List<HashMap<String, Object>> productList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> product = new HashMap<String,Object>();
		product.put("product_id", "sentest001");
		product.put("upc", "123");
		product.put("product_name", "杨森测试饭_大份");
		product.put("product_price", 3);
		product.put("product_amount", 1);
		product.put("product_fee", 3);
		product.put("package_price", 100);
		product.put("package_amount", "1");
		product.put("package_fee", 100);
		product.put("total_fee", 103);
		productList.add(product);
		
		body.put("product", productList);
		
		//5
		List<HashMap<String, Object>> discount = new ArrayList<HashMap<String, Object>>();
		body.put("discount", discount);
		
		
		
		map.put("body", body);
		
		
		String json = null;//JSON.toJSONString(map);
		   SerializeWriter out = new SerializeWriter();
	        try {
	            JSONSerializer serializer = new JSONSerializer(out);
	            serializer.config(SerializerFeature.PrettyFormat, false);
	            serializer.config(SerializerFeature.QuoteFieldNames, true);
	            serializer.config(SerializerFeature.UseSingleQuotes, false);
	            serializer.config(SerializerFeature.SortField, true);
	            serializer.config(SerializerFeature.WriteMapNullValue, false);
	            serializer.config(SerializerFeature.WriteNullStringAsEmpty, false);
	            serializer.write(map);
	            json = out.toString();
	            System.out.println(json);
	        } finally {
	            out.close();
	        }
		
		
		
		//String json = JSON.toJSONString(map);
	        
	        
		System.out.println("hashmap:"+json);
		json = Cmd.chinaToUnicode(json);
		String md5Sign = EncryptUtils.md5(json).toUpperCase();
		//System.out.println(md5Sign);

	
	}
		

	
	
}
