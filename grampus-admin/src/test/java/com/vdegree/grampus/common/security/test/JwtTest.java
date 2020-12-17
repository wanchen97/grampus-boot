package com.vdegree.grampus.common.security.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Title:
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-09
 */
@Slf4j
public class JwtTest {

	@Test
	public void testJwt() {
		String bearerToken = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIMDAxIiwiZXhwIjoxNjA4MzUzMzI3fQ.8QIKHqeWWh8rq32CVNG20-6vkwbV9-wVlqCz5LrVegdaHRNbJZO0asiIhMpha1_EhL2sxscyBL-nxX0LJvkGtQ";
		String result = bearerToken.substring(7);
		log.debug("result:{}", result);
	}
}
