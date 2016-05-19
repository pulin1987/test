package com.pulin.springbootpulin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
public class MyPropertiesConfiguration {
	
	private final static Logger logger = LoggerFactory.getLogger(MyPropertiesConfiguration.class);
 
    @Bean
    public  MyProperties  getMyProperties() {
       return new  MyProperties();
    }
}
