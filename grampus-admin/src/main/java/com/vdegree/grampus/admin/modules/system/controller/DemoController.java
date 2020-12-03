package com.vdegree.grampus.admin.modules.system.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vdegree.grampus.common.idgenerator.generator.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	private IdGenerator idGenerator;

	@GetMapping("/test")
	public ResponseEntity<Map<String, Object>> test() {
		log.debug("request demo. time:{}", System.currentTimeMillis());

		List<Long> ids = Lists.newLinkedList();
		for (int i = 0; i < 500; i++) {
			ids.add(idGenerator.genKey());
		}

		List<Long> disIds = ids.stream().distinct().collect(Collectors.toList());

		Map<String, Object> result = Maps.newHashMap();
		result.put("item", "demo.");
		result.put("ids", ids);
		result.put("count", disIds.size());
		return ResponseEntity.ok().body(result);
	}
}
