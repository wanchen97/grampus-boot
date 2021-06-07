package com.vdegree.grampus.admin.modules.system.security.redis;

import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.common.redis.utils.RedisCache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.List;

/**
 * 系统角色用户 Redis操作
 *
 * @author Beck
 * @since 2021-06-04
 */
@Component
@AllArgsConstructor
public class SystemRoleUserRedis {

	private final RedisCache redisCache;

	/**
	 * 用户详情资料缓存
	 * KEY sys:role_user:{roleId}
	 * VAL 权限标识String
	 */
	private static final String SYSTEM_ROLE_USER_KEY = "sys:role_user:{0}";

	/**
	 * @param roleId 角色ID
	 * @param userNoList 输入该角色的所有用户编号
	 */
	public void saveSystemRoleUser(Long roleId, List<String> userNoList) {
		String key = MessageFormat.format(SYSTEM_ROLE_USER_KEY, roleId);
		redisCache.setEx(key, userNoList, Duration.ofHours(3));
	}

	public void removeSystemRoleUser(Long roleId) {
		String key = MessageFormat.format(SYSTEM_ROLE_USER_KEY, roleId);
		redisCache.del(key);
	}

	public String getSystemRoleUser(Long roleId) {
		String key = MessageFormat.format(SYSTEM_ROLE_USER_KEY, roleId);
		return BeanUtil.copy(redisCache.get(key), String.class);
	}
}
