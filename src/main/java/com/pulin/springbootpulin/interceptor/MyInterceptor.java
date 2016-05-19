package com.pulin.springbootpulin.interceptor;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor  implements HandlerInterceptor{  
    /** 
     * This implementation always returns <code>true</code>. 
     */  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
    	System.out.println("preHandle start:"+request.getRequestURI());
    /*	InputStream input = request.getInputStream();
    	if(input != null){
    		List<String> lines = org.apache.commons.io.IOUtils.readLines(input);
    		StringBuilder sb = new StringBuilder();
        	for(String s: lines){
        		sb.append(s);
        	}
        	System.out.println(sb.toString());
    	}*/
    	
    	System.out.println("preHandle end");
    	
        return true;  
    }  
  
    /** 
     * This implementation is empty. 
     */  
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {  
    	
    
    }  
  
    /** 
     * This implementation is empty. 
     */  
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {  
    }  
}  