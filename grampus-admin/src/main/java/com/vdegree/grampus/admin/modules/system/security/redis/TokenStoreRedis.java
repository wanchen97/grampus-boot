package com.vdegree.grampus.admin.modules.system.security.redis;

import com.vdegree.grampus.admin.modules.system.security.manager.JwtTokenManager;
import com.vdegree.grampus.common.redis.utils.RedisCache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * Token store.
 *
 * @author Beck
 * @date 2021-04-02
 */
@Component
@AllArgsConstructor
public class TokenStoreRedis {

	private final RedisCache redisCache;
	private final JwtTokenManager tokenManager;

	public void saveToken(String token) {
		String subject = tokenManager.getSubject(token);
		saveToken(subject, token);
	}

	public void saveToken(String subject, String token) {
		redisCache.setEx(subject, token, Duration.ofHours(8));
	}
}
