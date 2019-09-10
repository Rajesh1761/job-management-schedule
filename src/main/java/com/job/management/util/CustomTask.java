package com.job.management.util;

import com.job.management.model.TaskModel;

public interface CustomTask {

	TaskModel executeTask(TaskModel taskModel)throws Exception;
}
