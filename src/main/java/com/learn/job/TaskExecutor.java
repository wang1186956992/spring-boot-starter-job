package com.learn.job;


import com.alibaba.fastjson.JSONObject;
import com.learn.job.entity.TimeTaskBean;
import com.learn.job.exception.TaskExecutorException;

/**
 * 任务处理器
 */
public interface TaskExecutor {

    /**
     * 定时任务执行的操作
     * @param param
     * @throws TaskExecutorException
     */
    void execTask(JSONObject param) throws TaskExecutorException;

    /**
     * 当定时任务执行失败的时候执行的操作
     * @param timeTask
     * @param e
     */
    void errorExecTask(TimeTaskBean timeTask, Exception e);
}
