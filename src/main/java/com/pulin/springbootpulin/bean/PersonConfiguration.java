package com.pulin.springbootpulin.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
public class PersonConfiguration {
	
	final static Logger logger = LoggerFactory.getLogger(PersonConfiguration.class);
  
    @Bean
    public Person getPsrson() {
       Person p = new Person();
       p.setAge("29");
       p.setName("plly");
       return p;
    }
}
