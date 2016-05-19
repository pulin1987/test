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
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Arrays;

@Configuration
public class RedisConfiguration {
	
	private final static Logger logger = LoggerFactory.getLogger(RedisConfiguration.class);

    public JedisConnectionFactory redisDbFactory() throws Exception {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(100);

        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPoolConfig(config);
        factory.setPassword("");
        factory.setHostName("");
        factory.setDatabase(0);
        factory.setPort(6379);

        return factory;
    }

   // @Bean
    public RedisTemplate redisTemplate() throws Exception {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisDbFactory());
        return redisTemplate;
    }

}
