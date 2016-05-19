package com.pulin.springbootpulin.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StopWatch;

import com.alibaba.fastjson.JSON;

public class PushReturnTest {
	
	public static void main(String[] args)  throws Exception{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		long s = System.currentTimeMillis();
		Map map = new HashMap(100000);
		 for(int i=0;i<50000;i++){
			Integer data =  (int) (Math.random()*100000+100000);
			map.put(data, data);
		 }
		 stopWatch.stop();
		 System.out.println(stopWatch.getTotalTimeMillis());
		 long e = System.currentTimeMillis();
		 //System.out.println(JSON.toJSONString(map,true));
		 System.out.println(e-s);
	}
	

	
}
