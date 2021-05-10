package com.vdegree.grampus.admin.modules.system.security.redis;

import com.vdegree.grampus.admin.modules.system.security.manager.JwtTokenManager;
import com.vdegree.grampus.common.redis.utils.RedisCache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.Duration;

/**
 * Token store.
 *
 * @author Beck
 * @since 2021-04-02
 */
@Component
@AllArgsConstructor
public class TokenStoreRedis {

	private final RedisCache redisCache;
	private final JwtTokenManager tokenManager;

	/**
	 * 用户详情资料缓存
	 * KEY sys:user_token:{userNo}
	 * VAL SystemUserDetails实体
	 */
	private static final String SYSTEM_USER_TOKEN_KEY = "sys:user_token:{0}";

	public void saveToken(String token) {
		String subject = tokenManager.getSubject(token);
		saveToken(subject, token);
	}

	public void saveToken(String subject, String token) {
		redisCache.setEx(MessageFormat.format(SYSTEM_USER_TOKEN_KEY, subject), token, Duration.ofHours(8));
	}

	public boolean checkToken(String subject, String token) {
		String realToken = redisCache.get(MessageFormat.format(SYSTEM_USER_TOKEN_KEY, subject));
		return realToken != null && realToken.equals(token);
	}

	public void deleteToken(String subject) {
		String key = MessageFormat.format(SYSTEM_USER_TOKEN_KEY, subject);
		redisCache.del(key);
	}
}
