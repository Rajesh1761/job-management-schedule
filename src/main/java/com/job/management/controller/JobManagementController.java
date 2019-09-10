package com.job.management.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.job.management.model.TaskModel;
import com.job.management.service.JobManagementService;
import com.job.management.util.JobConstants;
import com.job.management.util.JobType;
import com.job.management.util.TaskStatus;
import com.job.management.util.Utility;

@Controller
public class JobManagementController {

	@Value("${start-url-in-browser}")
	String strUrl;

	@Value("${dummy-task-name}")
	String dummyTaskName;

	@Autowired
	JobManagementService jobManagementService;

	ExecutorService executor = Executors.newCachedThreadPool();

	ScheduledExecutorService scheduledExecutorService = Executors
			.newScheduledThreadPool(1);

	private static Logger logger = LogManager.getLogger();

	public List<TaskModel> listOfTask = new CopyOnWriteArrayList<TaskModel>();

	private StringBuilder errorMessage = new StringBuilder("");

	@GetMapping("/dashboard")
	public String dashBoard(Model model) {
		return validResponse(model);
	}

	@PostMapping("/task")
	public String submitTask(@ModelAttribute TaskModel taskModel, Model model) {
		if (validateData(taskModel)) {
			Date time = Utility.getTimeForScheduling(taskModel);
			if (!listOfTask.contains(taskModel)) {
				logger.info(taskModel.getTaskName()
						+ JobConstants.JOB_SUBMITTED + time);
				taskModel.setId(listOfTask.size() + 1);
				taskModel.setTaskStatus(TaskStatus.QUEUED);
				jobManagementService.setTaskModel(taskModel);
				listOfTask.add(taskModel);
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						jobManagementService.process();
					}
				}, time);

			}
			return validResponse(model);
		} else {
			return inValidResponse(taskModel, model);
		}

	}

	private String validResponse(Model model) {
		errorMessage = new StringBuilder("");
		model.addAttribute("taskModel", new TaskModel());
		model.addAttribute("listOfTask", listOfTask);
		model.addAttribute("errorMessage", errorMessage.toString());
		return "tasks";
	}

	private String inValidResponse(TaskModel taskModel, Model model) {
		model.addAttribute("taskModel", taskModel);
		model.addAttribute("listOfTask", listOfTask);
		model.addAttribute("errorMessage", errorMessage.toString());
		return "tasks";
	}

	private boolean validateData(TaskModel taskModel) {
		boolean returnType = true;
		if (Utility.isNull(taskModel.getTaskName())) {
			errorMessage.append(JobConstants.TASK_NAME_CANNOT_NULL);
			returnType = false;
		}
		if (!Utility.valiDateHoursAndMinutes(taskModel.getScheduleHours(),
				JobConstants.HOURS)) {
			errorMessage.append(JobConstants.HOURS_VALUE);
			returnType = false;
		}
		if (!Utility.valiDateHoursAndMinutes(taskModel.getScheduleMinutes(),
				JobConstants.MINUTES)) {
			errorMessage.append(JobConstants.MINUTES_VALUE);
			returnType = false;
		}
		if (!Utility.valiDateTaskType(taskModel.getTaskType())) {
			errorMessage.append(JobConstants.TASK_TYPE_JAVA);
			returnType = false;
		}
		return returnType;

	}

	public void openBrowser(Desktop desktop) {
		try {
			desktop.browse(new URI(strUrl));
		} catch (IOException | URISyntaxException e) {
			logger.error(e.toString());
		} catch (Exception e) {
			logger.error(JobConstants.FAILED_TO_START + e.toString());
		}

	}

	@PostConstruct
	private void init() {
		logger.info(JobConstants.INIT_LOAD_DATA_MSG);
		TaskModel taskModel = new TaskModel();
		taskModel.setId(1);
		taskModel.setTaskName("Task 1");
		taskModel.setTaskDescription("Test Task 1");
		taskModel.setTaskType(JobType.Java);
		taskModel.setTaskLocation(dummyTaskName);
		taskModel.setScheduleHours(LocalTime.now().getHour());
		taskModel.setScheduleMinutes(LocalTime.now().getMinute() + 1);
		submitTestingTask(taskModel);
	}

	public void submitTestingTask(TaskModel taskModel) {
		Date time = Utility.getTimeForScheduling(taskModel);
		if (!listOfTask.contains(taskModel)) {
			logger.info(taskModel.getTaskName() + JobConstants.JOB_SUBMITTED
					+ time);
			taskModel.setId(listOfTask.size() + 1);
			taskModel.setTaskStatus(TaskStatus.QUEUED);
			jobManagementService.setTaskModel(taskModel);
			listOfTask.add(taskModel);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					jobManagementService.process();
				}
			}, time);

		}
	}
}
