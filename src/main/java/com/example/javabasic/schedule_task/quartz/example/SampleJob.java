package com.example.javabasic.schedule_task.quartz.example;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SampleJob extends QuartzJobBean {

    private String name;

    public void setName(String name){
        this.name = name;
    }


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("Quartz:Hello:"+this.name);
    }
}
