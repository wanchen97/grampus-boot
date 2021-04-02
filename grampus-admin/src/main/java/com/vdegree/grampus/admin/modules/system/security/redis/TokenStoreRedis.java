package com.vdegree.grampus.admin.modules.system.security.redis;

import com.vdegree.grampus.admin.modules.system.security.manager.JwtTokenManager;
import com.vdegree.grampus.common.redis.utils.RedisCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * Title: Token store.
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-02
 */
@Component
@RequiredArgsConstructor
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
