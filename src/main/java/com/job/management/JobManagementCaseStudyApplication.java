package com.job.management;

import java.awt.Desktop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.job.management.config.ApplicationConfig;
import com.job.management.controller.JobManagementController;
import com.job.management.util.JobConstants;

@SpringBootApplication
public class JobManagementCaseStudyApplication {

	private static Logger logger = LogManager.getLogger();

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		logger.info(JobConstants.STARTING_MSG);
		Desktop desktop = Desktop.getDesktop();
		applicationContext = SpringApplication.run(ApplicationConfig.class,
				args);
		JobManagementController myClass = (JobManagementController) applicationContext
				.getBean("jobManagementController");
		myClass.openBrowser(desktop);

	}
}
