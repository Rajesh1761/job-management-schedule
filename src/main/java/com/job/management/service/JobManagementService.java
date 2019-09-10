package com.job.management.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.management.model.TaskModel;
import com.job.management.util.CustomTask;
import com.job.management.util.JobConstants;
import com.job.management.util.JobType;
import com.job.management.util.TaskStatus;

@Service
public class JobManagementService {
	private static Logger logger = LogManager.getLogger();

	@Autowired
	CustomTask customTask;

	private TaskModel taskModel;

	public TaskModel process() {
		if (taskModel.getTaskType().equals(JobType.Java)) {
			taskModel.setTaskStatus(TaskStatus.RUNNING);
			try {
				taskModel = customTask.executeTask(taskModel);
			} catch (Exception e) {
				taskModel.setTaskStatus(TaskStatus.FAILED);
			}
		} else {
			logger.info(JobConstants.JOB_TYPE_NOT_FUNCTIONED);
		}
		return taskModel;
	}

	public TaskModel getTaskModel() {
		return taskModel;
	}

	public void setTaskModel(TaskModel taskModel) {
		this.taskModel = taskModel;
	}

}
