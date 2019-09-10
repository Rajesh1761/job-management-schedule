package com.job.management.service;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.job.management.model.TaskModel;
import com.job.management.util.CustomTask;
import com.job.management.util.JobConstants;
import com.job.management.util.TaskStatus;

@Component
public class JavaJobService implements CustomTask {
	String taskLocation = System.getProperty("user.dir") + File.separator;
	Process p = null;
	private static Logger logger = LogManager.getLogger();
	@Override
	public TaskModel executeTask(TaskModel taskModel) throws Exception {
		taskLocation = taskLocation + taskModel.getTaskLocation();
		String cmd = "cmd /c start cmd.exe /K \" " + JobConstants.JAVA_COMMAND
				+ taskModel.getTaskLocation() + "";
		try {
			p = Runtime.getRuntime().exec(cmd);
			logger.info(taskModel.getTaskName()+JobConstants.JOB_EXECUTION_RUNNING + cmd);
			Thread.sleep(30000);
			taskModel.setTaskStatus(TaskStatus.SUCCESS);
			logger.info(taskModel.getTaskName()+JobConstants.JOB_EXECUTION_COMPLETED);
		} catch (Exception e) {
			throw new Exception("" + e);
		}
		return taskModel;
	}
}
