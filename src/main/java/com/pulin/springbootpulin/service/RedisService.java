package com.pulin.springbootpulin.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisService {

	@Autowired
	private RedisTemplate redisTemplate;

	public void set(final byte[] key, final byte[] value , final long liveTime) throws Exception{
		redisTemplate.execute(new RedisCallback(){
			public Long doInRedis(RedisConnection connection)throws DataAccessException {
				connection.set(key,value);
				if (liveTime > 0) {
					connection.expire(key,liveTime);
				}
				return 1L;
			}
		});
	}


	public byte[] get(final byte[] key) throws Exception {
		return (byte[])redisTemplate.execute(new RedisCallback() {
			public byte[]doInRedis(RedisConnection connection)throws DataAccessException {
				return connection.get(key);
			}
		});

	}

	public long del(final String...keys) throws Exception{
		return (long)redisTemplate.execute(new RedisCallback() {
			public Long doInRedis(RedisConnection connection)throws DataAccessException {
				long result = 0;
				for (int i = 0; i < keys.length; i++) {
					result = connection.del(keys[i].getBytes());
				}
				return result;
			}
		});

	}


}