package com.pulin.springbootpulin.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * json数据解析递归按照key ASCII升序排序
 * @author MyPC
 *
 */
public class SortJsonUtils {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static TreeMap treemap(TreeMap originMap){
		Iterator iter = originMap.keySet().iterator();
		while(iter.hasNext()){
			Object key = iter.next();
			Object value = originMap.get(key);
			if(value instanceof JSONObject){
				 TreeMap map = JSON.parseObject(value.toString(), TreeMap.class);
				 originMap.put(key, treemap(map));
			}else if(value instanceof JSONArray){
				List list = JSON.parseObject(value.toString(), List.class);
				List list_data = new ArrayList();
				for(int i=0;i<list.size();i++){
					String s = list.get(i).toString();
					Object object = JSON.parseObject(s, Object.class);
					if(object instanceof JSONObject){
						TreeMap map =  JSON.parseObject(s, TreeMap.class);
						list_data.add(treemap(map));
					} else if(object instanceof JSONArray){
						System.out.println("不支持多维数组解析,此数据不是标准json数据，请检查");
					} else{
						list_data.add(object);
					}
				}
				originMap.put(key,list_data);
			}else{
				 originMap.put(key, value);
			}
		}
		return originMap;
	}
	
	
	   /**
     * unicode 转码
     *
     * @param str
     * @return
     */
    public static String chinaToUnicode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) {
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
		String s = "[[],[]]";
		Object object = JSON.parseObject(s, Object.class);
		if(object instanceof JSONObject){
			System.out.println("JSONObject");
		}
		if(object instanceof JSONArray){
			System.out.println("JSONArray");
		}
	}
}