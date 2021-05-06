package com.vdegree.grampus.common.security.test;

import com.vdegree.grampus.admin.GrampusBootAdminApplication;
import com.vdegree.grampus.common.redis.utils.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Title:
 *
 * @author Beck
 * @since 2020-12-09
 */
@Slf4j
@SpringBootTest(classes = GrampusBootAdminApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JwtTest {

	@Test
	public void testJwt() {
		String bearerToken = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIMDAxIiwiZXhwIjoxNjA4MzUzMzI3fQ.8QIKHqeWWh8rq32CVNG20-6vkwbV9-wVlqCz5LrVegdaHRNbJZO0asiIhMpha1_EhL2sxscyBL-nxX0LJvkGtQ";
		String result = bearerToken.substring(7);
		log.debug("result:{}", result);
	}

	@Autowired
	private RedisCache redisCache;

	@Test
	public void test2() {
		redisCache.hSet("test_hset_key", "testField", "1111111");
		redisCache.expire("test_hset_key", 0);
		log.info("..........................");
	}
}
