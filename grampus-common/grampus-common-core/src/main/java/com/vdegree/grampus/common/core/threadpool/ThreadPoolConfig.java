package com.vdegree.grampus.common.core.threadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author Beck
 * @since 2020-12-5
 */
@Configuration
public class ThreadPoolConfig {

	/**
	 * 核心线程池大小
	 */
	private static final int CORE_POOL_SIZE = 50;
	/**
	 * 最大可创建的线程数
	 */
	private static final int MAX_POOL_SIZE = 200;
	/**
	 * 队列最大长度
	 */
	private static final int QUEUE_CAPACITY = 1000;
	/**
	 * 线程池维护线程所允许的空闲时间
	 */
	private static final int KEEP_ALIVE_SECONDS = 300;

	/**
	 * 线程池任务
	 */
	@Bean(name = "threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(CORE_POOL_SIZE);
		executor.setMaxPoolSize(MAX_POOL_SIZE);
		executor.setQueueCapacity(QUEUE_CAPACITY);
		executor.setKeepAliveSeconds(KEEP_ALIVE_SECONDS);
		// 线程池对拒绝任务(无线程可用)的处理策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		return executor;
	}

//	/**
//	 * 执行周期性或定时任务
//	 */
//	@Bean(name = "scheduledExecutorService")
//	protected ScheduledExecutorService scheduledExecutorService() {
//		return new ScheduledThreadPoolExecutor(CORE_POOL_SIZE,
//				new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build()) {
//			@Override
//			protected void afterExecute(Runnable r, Throwable t) {
//				super.afterExecute(r, t);
//			}
//		};
//	}
}
