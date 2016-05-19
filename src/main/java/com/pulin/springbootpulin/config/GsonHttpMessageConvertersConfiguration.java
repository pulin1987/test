package com.pulin.springbootpulin.config;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;




@Configuration
public class GsonHttpMessageConvertersConfiguration {
	
	private final static Logger logger = LoggerFactory.getLogger(GsonHttpMessageConvertersConfiguration.class);
    /*
     * GsonHttpMessageConverter 转换配置
     */
    @Bean
    public HttpMessageConverters gsonHttpMessageConverters() {
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList();
        // Gson 配置
        //GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        logger.info("GsonHttpMessageConverter 转换配置");
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        messageConverters.add(fastJsonHttpMessageConverter);
        return new HttpMessageConverters(false, messageConverters);
    }
}
