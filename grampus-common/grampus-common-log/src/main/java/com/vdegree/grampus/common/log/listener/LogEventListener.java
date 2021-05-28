package com.vdegree.grampus.common.log.listener;

import com.vdegree.grampus.common.log.event.LogEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * SysLogEventListener
 *
 * @author Beck
 * @since 2021-05-28
 */
@Slf4j
public class LogEventListener {

	@Async
	@Order
	@EventListener(LogEvent.class)
	public void onApplicationEvent(LogEvent event) {
		log.debug("listen LogEvent:{}", event);
	}
}
