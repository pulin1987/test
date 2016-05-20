package com.pulin.springbootpulin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfiguration {
	
	private final static Logger logger = LoggerFactory.getLogger(RedisConfiguration.class);

    public JedisConnectionFactory redisFactory() throws Exception {
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


    public RedisTemplate redisTemplate() throws Exception {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisFactory());
        return redisTemplate;
    }



    public JedisConnectionFactory redisSentineFactory() throws Exception {
        RedisNode node = new RedisNode("192.168.0.100",6379);
        RedisNode node2 = new RedisNode("192.168.0.100",6380);
        RedisNode node3 = new RedisNode("192.168.0.100",6381);
        RedisSentinelConfiguration sentinel = new RedisSentinelConfiguration();
        sentinel.master(node);
        sentinel.sentinel(node2);
        sentinel.sentinel(node3);

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(100);

        JedisConnectionFactory factory = new JedisConnectionFactory(sentinel,config);

        return factory;
    }

    @Bean
    public RedisTemplate redisSentineTemplate() throws Exception {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisSentineFactory());
        return redisTemplate;
    }

}
