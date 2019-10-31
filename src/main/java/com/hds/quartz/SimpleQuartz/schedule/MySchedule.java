package com.hds.quartz.SimpleQuartz.schedule;

import com.hds.quartz.SimpleQuartz.job.TestJob;
import org.quartz.*;
import org.quartz.spi.MutableTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @Classname MySchdule
 * @Description TODO 任务调度处理  配置
 * @Date 2019/10/31 22:05
 * @Created by huangdasheng
 */
@Configuration
public class MySchedule {

    private static Logger logger =LoggerFactory.getLogger(MySchedule.class);

    @Autowired
    private Scheduler scheduler;
    /**
     * @Author huangds
     * @Description //TODO 运行任务方法
     * @Date 22:15 2019/10/31
     * @Param
     * @return
     **/
    public void configJob() throws SchedulerException {
        /*创建JOB实例*/
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class).withIdentity("job1", "group1").build();
        /*创建Trigger实例*/
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/1 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("job1", "group1").withSchedule(cronScheduleBuilder).build();
        Date date = scheduler.scheduleJob(jobDetail, trigger);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        logger.info(format+"runJob时间");
    }

    public void runJob() throws SchedulerException {
        configJob();
        /*开始Schedule*/
        scheduler.start();
    }

    /*注入Spring容器*/
    @Bean
    public Scheduler scheduler() throws SchedulerException {
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        return sched;
    }
}
