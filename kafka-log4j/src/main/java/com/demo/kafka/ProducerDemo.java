package com.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 这个是demo 主要用来测试生产者的单条信息发送和批量信息发送
 */
public class ProducerDemo {

	private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class);

	public static void main(String args[]) throws InterruptedException {
		for (int i = 0; i <= 10; i++) {
			// 以下三条日志，仅 error 级别的日志会被写入 kafka (配置项  log4j.appender.KAFKA.Threshold)			
			log.info("trace:This is Message [{}] from log4j producer .. ", i);
			log.info("This is Message [{}] from log4j producer .. ", i);
			log.error("这是一条 error 级别的日志！！");
			Thread.sleep(1000);
		}
	}
}