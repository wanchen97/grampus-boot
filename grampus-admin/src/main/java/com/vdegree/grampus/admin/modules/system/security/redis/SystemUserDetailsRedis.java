package com.vdegree.grampus.admin.modules.system.security.redis;

import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.common.redis.utils.RedisCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.Duration;

/**
 * Title: 会员详细信息缓存
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-02
 */
@Component
@RequiredArgsConstructor
public class SystemUserDetailsRedis {

	private final RedisCache redisCache;

	/**
	 * 用户详情资料缓存
	 * KEY sys:user_details:{userNo}
	 * VAL SystemUserDetails实体
	 */
	private static final String SYSTEM_USER_DETAILS_KEY = "sys:user_details:{0}";

	public void saveSystemUserDetails(SystemUserDetails userDetails) {
		String key = MessageFormat.format(SYSTEM_USER_DETAILS_KEY, userDetails.getUserNo());
		redisCache.setEx(key, userDetails, Duration.ofHours(8));
	}

	public void removeSystemUserDetails(String userNo) {
		String key = MessageFormat.format(SYSTEM_USER_DETAILS_KEY, userNo);
		redisCache.del(key);
	}

	public SystemUserDetails getSystemUserDetails(String userNo) {
		String key = MessageFormat.format(SYSTEM_USER_DETAILS_KEY, userNo);
		return BeanUtil.copy(redisCache.get(key), SystemUserDetails.class);
	}
}
