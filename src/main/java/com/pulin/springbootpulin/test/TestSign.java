package com.pulin.springbootpulin.test;

import java.io.File;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.pulin.springbootpulin.utils.Cmd;
import com.pulin.springbootpulin.utils.EncryptUtils;

public class TestSign {
	
	public static void main(String[] args)  throws Exception{
/*		String json = org.apache.commons.io.FileUtils.readFileToString(new File("F:/order.txt"), "UTF-8").trim();
		System.out.println(json);
		json = Cmd.chinaToUnicode(json);
		if(json.startsWith("\\ufeff")){ 
			json = json.substring(1); 
			json = json.replace("ufeff", ""); 
		}
		System.out.println(json);
		String md5Sign = EncryptUtils.md5(json).toUpperCase();
		System.out.println(md5Sign);*/
		

		String ttt2 = org.apache.commons.io.FileUtils.readFileToString(new File("F:/push.txt"), "UTF-8").trim();
		//{"body":{"dish_id":"31","shop_id":"247900001"},"cmd":"dish.get","source":"65487","ticket":"2B06D9B7-2497-48A5-857B-56762DF5EF09","timestamp":1458184086,"version":"2.0"}
		TreeMap<String, Object> map = new TreeMap<String,Object>();
		map.put("cmd", "dish.get");
		map.put("timestamp", 1458184086); 
		map.put("version", "2.0");
		map.put("ticket", "2B06D9B7-2497-48A5-857B-56762DF5EF09");
		map.put("source", "65487");
		map.put("secret", "85bff21a43cb8da6");
		
		TreeMap<String, Object> body = new TreeMap<String,Object>();
		body.put("dish_id", "31");
		body.put("shop_id", "247900001");
		body.put("shop_name", "麻婆豆腐2abc哈哈");
		map.put("body", body);
		String json = new Gson().toJson(map);
		System.out.println(json);
		System.out.println(Cmd.getSign(map));
		ttt2 = Cmd.chinaToUnicode(ttt2);
		
		if(ttt2.startsWith("\ufeff")){ 
			ttt2 = ttt2.substring(1); 
			ttt2 = ttt2.replace("\ufeff", ""); 
		}
		
		System.out.println(ttt2);
		String md5Sign = EncryptUtils.md5(ttt2).toUpperCase();
		System.out.println(md5Sign);
	
	}
		

	
	
}
