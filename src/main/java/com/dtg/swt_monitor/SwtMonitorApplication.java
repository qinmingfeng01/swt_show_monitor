package com.dtg.swt_monitor;

import com.dtg.swt_monitor.SysConfig.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.dtg.swt_monitor.*")
public class SwtMonitorApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(SwtMonitorApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SwtMonitorApplication.class, args);
		logger.info("springboot启动成功");
		SpringContextUtil.setApplicationContext(applicationContext);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SwtMonitorApplication.class);
	}

}
