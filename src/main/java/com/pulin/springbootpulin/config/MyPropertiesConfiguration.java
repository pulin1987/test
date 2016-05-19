package com.pulin.springbootpulin.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Arrays;


@Configuration
public class MyPropertiesConfiguration {
	
	private final static Logger logger = LoggerFactory.getLogger(MyPropertiesConfiguration.class);
 
    @Bean
    public  MyProperties  getMyProperties() {
       return new  MyProperties();
    }


}
