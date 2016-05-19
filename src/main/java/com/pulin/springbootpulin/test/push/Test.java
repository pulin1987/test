package com.pulin.springbootpulin.test.push;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pulin.springbootpulin.test.push.deserializer.HashMapDeserializer;
import com.pulin.springbootpulin.test.push.serializer.AvailableTimeSerializer;
import com.pulin.springbootpulin.test.push.serializer.BodySerializer;
import com.pulin.springbootpulin.test.push.serializer.DataSerializer;
import com.pulin.springbootpulin.test.push.serializer.HashMapSerializer;
import com.pulin.springbootpulin.test.push.serializer.NormSerializer;

public class Test {
	
	public static void main(String[] args)  throws Exception{
		
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(Body.class, new BodySerializer())
				.registerTypeAdapter(Data.class, new DataSerializer())
				.registerTypeAdapter(AvailableTime.class, new AvailableTimeSerializer())
				.registerTypeAdapter(Norm.class, new NormSerializer())
				.registerTypeAdapter(HashMap.class, new HashMapSerializer())
				.registerTypeAdapter(HashMap.class, new HashMapDeserializer())
				.disableHtmlEscaping()
				.create();
		
			Body body = new Body();
			Result r = new Result();
			r.setBody(body);
			String signJson = gson.toJson(r);
			
			System.out.println(signJson);
			
			//对所有/进行转义
			signJson = signJson.replace("/", "\\/");
			//中文字符转为unicode
			signJson = chinaToUnicode(signJson);
			System.out.println(signJson);
			String sign = getMD5(signJson);
			System.out.println(sign);

		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("z", "z");
		map.put("a", "a");
		map.put("c", "c");
		map.put("d", "d");
		map.put("k", "k");
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		
		
	/*	TreeMap<Integer,String> treemap = new TreeMap<Integer,String>(
				new Comparator<Integer>(){
		            public int compare(Integer a,Integer b){
		                 return 0;
		            }
		             
		        });*/
		
	}
	
	
	/**
	 * 计算MD5
	 * @param input
	 * @return
	 */
	public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * 格式化成unicode的格式
	 * @param unicode
	 * @return
	 */
	public static String formatUnicode(String unicode){
		int length = 4 - unicode.length();
		for (int i = 0; i < length; i++){
			unicode = "0" + unicode;
		}
		return unicode;
	}
	
	/**
	 * 把中文转成Unicode码
	 * @param str
	 * @return
	 */
	public static String chinaToUnicode(String str){
		String result="";
		for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(chr1>=128&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
            	String unicode = String.valueOf(Integer.toHexString(chr1));
                result+="\\u" + formatUnicode(unicode);
            }else{
            	result+=str.charAt(i);
            }
        }
		return result;
	}
	
	
	
	
	
	
	
	

	
	
}
