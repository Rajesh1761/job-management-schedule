package com.job.management.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.job.management.controller",
		"com.job.management.config", "com.job.management.service" })
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
}
