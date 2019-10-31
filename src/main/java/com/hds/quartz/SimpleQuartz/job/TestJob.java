package com.hds.quartz.SimpleQuartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Classname TestJob
 * @Description TODO
 * @Date 2019/10/31 21:56
 * @Created by huangdasheng
 */
public class TestJob implements Job {

    private static Logger logger =LoggerFactory.getLogger(TestJob.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDate localDate1 = LocalDate.now();
        String now = localDate1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.info("任务开启"+now);
        LocalDate localDate2 = LocalDate.now();
        String after = localDate2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.info("任务结束"+after);
    }
}
