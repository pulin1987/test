package com.pulin.springbootpulin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;



@Data
@ConfigurationProperties("pulin")
public class MyProperties {
	
	private int port;


}
