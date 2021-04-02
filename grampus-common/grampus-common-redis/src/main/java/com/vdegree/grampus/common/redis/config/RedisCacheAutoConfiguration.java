package com.vdegree.grampus.common.redis.config;

import com.vdegree.grampus.common.redis.serializer.JsonRedisSerializer;
import com.vdegree.grampus.common.redis.utils.RedisCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Title: RedisCacheAutoConfiguration
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-02
 */
@Configuration
public class RedisCacheAutoConfiguration {

	@Resource
	private RedisConnectionFactory factory;

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
		redisTemplate.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
//		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new JsonRedisSerializer<>(Map.class));
        redisTemplate.setHashValueSerializer(new JsonRedisSerializer<>(Map.class));
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}

	@Bean
	public RedisCache redisClient(RedisTemplate<String, Object> redisTemplate) {
		return new RedisCache(redisTemplate);
	}
}
