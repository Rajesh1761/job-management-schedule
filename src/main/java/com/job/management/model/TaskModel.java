package com.job.management.model;

import java.io.Serializable;

import com.job.management.util.JobType;
import com.job.management.util.TaskStatus;

public class TaskModel implements Serializable {

	/**
	 * @author Rajesh Mishra
	 */
	private static final long serialVersionUID = 1473396488816918575L;
	private int id;
	
	private String taskName;
	
	private String scheduleDate;
	
	private int scheduleHours = -1;
	
	private int scheduleMinutes = -1;
	
	private String priority;
	
	private JobType taskType;
	
	private String taskLocation;
	
	private TaskStatus taskStatus;
	
	private String taskDescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public int getScheduleHours() {
		return scheduleHours;
	}

	public void setScheduleHours(int scheduleHours) {
		this.scheduleHours = scheduleHours;
	}

	public int getScheduleMinutes() {
		return scheduleMinutes;
	}

	public void setScheduleMinutes(int scheduleMinutes) {
		this.scheduleMinutes = scheduleMinutes;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public JobType getTaskType() {
		return taskType;
	}

	public void setTaskType(JobType taskType) {
		this.taskType = taskType;
	}

	public String getTaskLocation() {
		return taskLocation;
	}

	public void setTaskLocation(String taskLocation) {
		this.taskLocation = taskLocation;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result
				+ ((scheduleDate == null) ? 0 : scheduleDate.hashCode());
		result = prime * result
				+ ((taskDescription == null) ? 0 : taskDescription.hashCode());
		result = prime * result
				+ ((taskLocation == null) ? 0 : taskLocation.hashCode());
		result = prime * result
				+ ((taskName == null) ? 0 : taskName.hashCode());
		result = prime * result
				+ ((taskType == null) ? 0 : taskType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskModel other = (TaskModel) obj;
		/*if (id != other.id)
			return false;*/
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (scheduleDate == null) {
			if (other.scheduleDate != null)
				return false;
		} else if (!scheduleDate.equals(other.scheduleDate))
			return false;
		if (taskDescription == null) {
			if (other.taskDescription != null)
				return false;
		} else if (!taskDescription.equals(other.taskDescription))
			return false;
		if (taskLocation == null) {
			if (other.taskLocation != null)
				return false;
		} else if (!taskLocation.equals(other.taskLocation))
			return false;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
	/*	if (taskStatus == null) {
			if (other.taskStatus != null)
				return false;
		} else if (!taskStatus.equals(other.taskStatus))
			return false;*/
		if (taskType == null) {
			if (other.taskType != null)
				return false;
		} else if (!taskType.equals(other.taskType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaskModel [id=" + id + ", taskName=" + taskName
				+ ", scheduleDate=" + scheduleDate + ", scheduleHours="
				+ scheduleHours + ", scheduleMinutes=" + scheduleMinutes
				+ ", priority=" + priority + ", taskType=" + taskType
				+ ", taskLocation=" + taskLocation + ", taskStatus="
				+ taskStatus + ", taskDescription=" + taskDescription + "]";
	}

}
