package com.vdegree.grampus.common.redis.serializer;

import com.vdegree.grampus.common.core.utils.JSONUtil;
import com.vdegree.grampus.common.core.utils.chars.Charsets;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * Redis 自定义序列化
 *
 * @author Beck
 * @date 2021-04-02
 */
public class JsonRedisSerializer<T> implements RedisSerializer<T> {

	private Class<T> type;

	public JsonRedisSerializer(Class<T> type) {
		this.type = type;
	}

	@Override
	public byte[] serialize(T t) throws SerializationException {
		if (t == null) {
			return new byte[0];
		}
		return JSONUtil.writeValueAsString(t).getBytes(Charsets.UTF_8);
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length <= 0) {
			return null;
		}
		return JSONUtil.readValue(new String(bytes, Charsets.UTF_8), type);
	}
}