package com.vdegree.grampus.admin.modules.system.controller;

import com.google.common.collect.Maps;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Title: DemoController
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-11-26
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	@GetMapping("/test")
	public ResponseEntity<Map<String, Object>> test() {
		Map<String, Object> result = Maps.newHashMap();
		result.put("item", "demo.");
		return ResponseEntity.ok().body(result);
	}
}
