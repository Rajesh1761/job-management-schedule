package com.job.management.util;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import com.job.management.model.TaskModel;

public class Utility {

	public static Date getTimeForScheduling(TaskModel taskModel) {
		int hours = 0;
		int minute = 0;
		int second = LocalTime.now().getSecond() + 30;
		if (taskModel.getScheduleHours() >= 0
				&& taskModel.getScheduleMinutes() >= 0) {
			hours = taskModel.getScheduleHours();
			minute = taskModel.getScheduleMinutes();
		} else {
			hours = LocalTime.now().getHour();
			minute = LocalTime.now().getMinute();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hours);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		Date time = calendar.getTime();
		return time;
	}
	
	public static boolean isNull(Object obj){
		return obj==null ? true : false;
	}
	public static boolean valiDateHoursAndMinutes(int obj, String type){
		if(type.equals(JobConstants.HOURS)){
			if(obj >= -1 && obj <= 23){
				return true;
			}
		}else if(type.equals(JobConstants.MINUTES)){
			if(obj >= -1 && obj <= 59){
				return true;
			}
		}
		return false;
	}
	public static boolean valiDateTaskType(JobType obj){
		if(obj.equals(JobType.Java)){
			return true;
		}else{
			return false;
		}
		
	}
}
