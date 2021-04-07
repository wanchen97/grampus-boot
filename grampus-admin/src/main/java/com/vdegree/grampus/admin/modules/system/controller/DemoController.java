package com.vdegree.grampus.admin.modules.system.controller;

import com.google.common.collect.Maps;
import com.vdegree.grampus.admin.modules.system.entity.SysDept;
import com.vdegree.grampus.admin.modules.system.security.redis.SystemUserDetailsRedis;
import com.vdegree.grampus.admin.modules.system.security.roles.dao.SystemRoleDao;
import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
import com.vdegree.grampus.admin.modules.system.security.utils.SecurityUtils;
import com.vdegree.grampus.admin.modules.system.service.SysDeptService;
import com.vdegree.grampus.common.lock.annotation.DistributedLock;
import com.vdegree.grampus.common.lock.strategy.RedissonLockStrategy;
import com.vdegree.grampus.common.mybatis.enums.DelFlagEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title: DemoController
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-11-26
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private SysDeptService sysDeptService;
	@Autowired
	private DemoService demoService;
	@Autowired
	private SystemRoleDao systemRoleDao;

	private static ExecutorService threadPool = Executors.newFixedThreadPool(100);

	@PreAuthorize("hasAuthority('sys:demo:save')")
	@GetMapping("/save")
	public ResponseEntity<Map<String, Object>> test2() {
		SysDept sysDept = new SysDept();
		sysDept.setDeptName(UUID.randomUUID().toString());
		sysDept.setCreateBy(1L);
		sysDept.setCreateDate(new Date());
		sysDept.setUpdateBy(1L);
		sysDept.setUpdateDate(new Date());
		sysDept.setDelFlag(DelFlagEnum.NORMAL.getValue());
		sysDeptService.insert(sysDept);
		Map<String, Object> result = Maps.newHashMap();
		result.put("sysDept", sysDept);
		return ResponseEntity.ok().body(result);
	}

	@PreAuthorize("hasAuthority('sys:demo:list')")
	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> list() {
		Map<String, Object> result = Maps.newHashMap();
		result.put("list", sysDeptService.selectAll());
		return ResponseEntity.ok().body(result);
	}

	@PreAuthorize("hasAuthority('sys:demo:delete')")
	@GetMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
		sysDeptService.deleteById(id);
		Map<String, Object> result = Maps.newHashMap();
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/test")
	public ResponseEntity<Void> test() {
		for (int i = 0; i < 20; i++) {
			threadPool.execute(() -> {
				try {
					demoService.testLock("user1", "user2", "user3");
				} catch (Exception e) {

				}
			});
		}
		return ResponseEntity.ok().build();
	}

	//	@GetMapping("/test1")
	public ResponseEntity test1() {
		Set<String> set = systemRoleDao.getPermissions(126742336940032000L);
		return ResponseEntity.ok(set);
	}

	@Autowired
	private SystemUserDetailsRedis systemUserDetailsRedis;
	@GetMapping("/test1")
	public ResponseEntity test3() {
		SystemUserDetails userDetails = SecurityUtils.getUserDetails();
		systemUserDetailsRedis.saveSystemUserDetails(userDetails);
		return ResponseEntity.ok(systemUserDetailsRedis.getSystemUserDetails(userDetails.getUserNo()));
	}

	@Slf4j
	@Service
	public static class DemoService {

		@DistributedLock(keys = {"#userId", " #userId2", "#userId3"}, waitTime = 200, leaseTime = 40000, strategy = RedissonLockStrategy.class)
		public void testLock(String userId, String userId2, String userId3) throws InterruptedException {
			Thread.sleep(500);
			log.info("{} time:{}", Thread.currentThread().getName(), System.currentTimeMillis());
		}
	}

}
