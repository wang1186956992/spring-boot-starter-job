package com.learn.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.learn.application.context.SpringContextUtil;
import com.learn.job.entity.TimeTaskBean;
import com.learn.job.service.TimeTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by y003 on 2016/11/29.
 */

public class TimeTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 页数
     */
    private static int EXEC_PAGE_SIZE = 100;



    public static TimeTaskService getTimeTaskService(){
        TimeTaskService timeTaskService = SpringContextUtil.getBean(TimeTaskService.class);
        return timeTaskService;
    }



    public void execute(){

        logger.info("定时任务开始执行");
        int pageNo=1;

        List<? extends TimeTaskBean> list;

        do {

            list = getTimeTaskService().findByTimeTaskBeanList(pageNo,EXEC_PAGE_SIZE);

            for (TimeTaskBean temp : list) {
                exec(temp);
            }

            pageNo++;
        }while (list.size()>0);


        logger.info("定时任务执行结束");
    }


    /**
     * 执行任务
     * @param timeTaskBean
     */
    protected void exec(TimeTaskBean timeTaskBean){
        String taskCode = timeTaskBean.getTaskCode();
        TaskExecutor taskExecutor = SpringContextUtil.getBean(taskCode, TaskExecutor.class);


        //没有定时任务处理器
        if (taskExecutor == null){
            return;
        }

        try {
            String params = timeTaskBean.getParams();
            JSONObject jsonObject = JSON.parseObject(params);
            taskExecutor.execTask(jsonObject);

            //任务成功，修改任务状态
            getTimeTaskService().updateTimeTaskExec(timeTaskBean.getId());

        } catch (Exception e) {
            logger.error(e.getMessage());

            //任务失败，修改任务状态
            getTimeTaskService().updateTimeTaskError(timeTaskBean.getId(),e.getMessage());

            //执行任务
            taskExecutor.errorExecTask(timeTaskBean,e);
        }
    }





}
