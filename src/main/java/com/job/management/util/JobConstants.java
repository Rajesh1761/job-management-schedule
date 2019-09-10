package com.job.management.util;

public interface JobConstants {

    String STARTING_MSG="Job Management application is starting up";
    String INIT_LOAD_DATA_MSG="Job Management system is initializating, so loading testing data ...";
    String JOB_EXECUTION_RUNNING=" Job execution started executing by using command : ";
    String JOB_EXECUTION_COMPLETED=" Job execution completed successfully ...";
    String FAILED_TO_START=" Failed to start application ";
    String JAVA_COMMAND="java -jar ";
    String JOB_TYPE_NOT_FUNCTIONED="we are not supporting this job type as of now";
    String JOB_SUBMITTED=" has been submitted for execution at ";
    String NEW_LINE=", \n ";
    String TASK_NAME_CANNOT_NULL=" Task name cannot be blank or null "+JobConstants.NEW_LINE;
    String HOURS_VALUE=" Hours value should be between -1 to 23 "+JobConstants.NEW_LINE;
    String MINUTES_VALUE=" Minutes value should be between -1 to 59 "+JobConstants.NEW_LINE;
    String TASK_TYPE_JAVA=" As of now this process is only applicable to Java "+JobConstants.NEW_LINE;
    String HOURS="HOURS";
    String MINUTES="MINUTES";
}
