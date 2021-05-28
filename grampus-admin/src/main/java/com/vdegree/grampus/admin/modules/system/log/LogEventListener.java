package com.vdegree.grampus.admin.modules.system.log;

import com.vdegree.grampus.common.log.event.LogEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * SysLogEventListener
 *
 * @author Beck
 * @since 2021-05-28
 */
@Slf4j
@Component
public class LogEventListener {

	@Async
	@Order
	@EventListener(LogEvent.class)
	public void onApplicationEvent(LogEvent event) {
		log.debug("listen LogEvent:{}", event);
	}
}
