package com.pulin.springbootpulin.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;


/**
 * 请求百度外卖接口参数封装
 */
public class Cmd<T> implements Serializable {
    public static final Logger logger = LoggerFactory.getLogger(Cmd.class);
    private static final Gson gson = new Gson();// GsonUtils.getTreeMapDeserializerGson();
    private static final String SIGN_MODEL = "DEBUG";
    public final static String VERSION = "2.0";
	public final static String SOURCE = "65487";
    private final static String SECRET = "85bff21a43cb8da6";

    private String cmd;
    private Long timestamp;
    private String version;
    private String ticket;
    private String source;
    private String sign;

    private T body;


    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    /**
     * @param content
     * @return
     */
    public static TreeMap<String, Object> rebuild(final String content) {
    	logger.info("content:"+content);
        TreeMap<String, Object> cmdMap = gson.fromJson(content, TreeMap.class);
        TreeMap<String, Object> body = new TreeMap<>(((LinkedTreeMap<String, Object>) cmdMap.get("body")));
        cmdMap.put("body", rebuild(body));
        cmdMap.put("timestamp", ((Double) cmdMap.get("timestamp")).longValue());
        return cmdMap;
    }

    /**
     * 递归排序，验证签名
     * @param treeMap
     * @return
     */
    private static TreeMap<String, Object> rebuild(TreeMap<String, Object> treeMap) {
        Iterator<Map.Entry<String, Object>> iter = treeMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Object> entry = iter.next();
            String key = entry.getKey();
            Object obj = entry.getValue();
            // 如果是ArrayList
            if (obj instanceof ArrayList) { // Array
                ArrayList arrayList = (ArrayList) obj;
                ArrayList<Object> rebuildList = new ArrayList<>();
                for (Object o : arrayList) {
                    if (o instanceof LinkedTreeMap) { // LinkedTreeMap
                        rebuildList.add(rebuild(new TreeMap<>(((LinkedTreeMap<String, Object>) o))));
                    }
                }
                treeMap.put(key, rebuildList);
            } else if (obj instanceof LinkedTreeMap) {
                treeMap.put(key, rebuild(new TreeMap<>(((LinkedTreeMap<String, Object>) obj))));
            } else if (obj instanceof Double) {
                if (!key.equals("latitude") && !key.equals("longitude")) {
                    treeMap.put(key, ((Double) obj).longValue());
                }
            }
        }
        return treeMap;
    }

    /**
     * 签名公用方法
     * @param jsonContent
     * @return
     */
    public static boolean sign(final String jsonContent) {
        TreeMap<String, Object> cmdMap = rebuild(jsonContent);
        String sign = cmdMap.get("sign").toString();
        cmdMap.remove("sign");
        cmdMap.put("secret", "85bff21a43cb8da6");
        String json = gson.toJson(cmdMap);
        json = json.replace("/", "\\/");
        json = chinaToUnicode(json);
        String serverSign = EncryptUtils.md5(json).toUpperCase();
        logger.debug("serverSign = [ {} ] , serverMd5Sign = [ {} ] ", sign, serverSign);
        // 校验模式
        if (!SIGN_MODEL.equals("RUN")) {
            return true;
        }
        if (sign.equals(serverSign)) {
            return true;
        }
        return false;
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
    
    
    
	/**
	 * 获取百度请求的签名
	 */
	public static String getSign(TreeMap<String, Object> requestMap) {
		String json = gson.toJson(requestMap);
		json = chinaToUnicode(json);
		logger.info("getSign:"+json);
		String md5Sign = EncryptUtils.md5(json).toUpperCase();
		return md5Sign;
	}
	
	/**
	 * 获取请求体
	 */
	public static String getRequestSubmit(String cmd, TreeMap<String, Object> body) {
		TreeMap<String, Object> requestMap = getRequestMap(cmd, body);
		String md5Sign = getSign(requestMap);
		logger.info("md5Sign:"+md5Sign);
		requestMap.put("sign", md5Sign);
		//requestMap.put("secret",null);
		String json = gson.toJson(requestMap);
		logger.info("getRequestSubmit_json_result:"+json);
		return json;
	}
	
	public static TreeMap<String, Object> getRequestMap(String cmd, TreeMap<String, Object> body) {
		TreeMap<String, Object> map = new TreeMap<String, Object>();
		map.put("cmd", cmd);
		map.put("timestamp", System.currentTimeMillis() / 1000);
		map.put("version", VERSION);
		map.put("ticket", UUID.randomUUID().toString().toUpperCase());
		map.put("source", SOURCE);
		map.put("secret", SECRET);
		map.put("body", body);
		return map;
	}
	
	/**
	 * 获取响应体
	 */
	public static String getResponseJson(String cmd, TreeMap<String, Object> body) {
		TreeMap<String, Object> requestMap = getRequestMap(cmd, body);
		String md5Sign = getSign(requestMap);
		requestMap.put("sign", md5Sign);
        requestMap.remove("secret");
		return chinaToUnicode(gson.toJson(requestMap));
	}
	
	

}