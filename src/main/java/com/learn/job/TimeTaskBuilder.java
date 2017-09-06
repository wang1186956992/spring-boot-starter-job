package com.learn.job;

import com.alibaba.fastjson.JSON;
import com.learn.job.entity.TimeTaskBean;
import com.learn.job.entity.enumType.TaskStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 定时任务构造器
 */
public class TimeTaskBuilder {
    protected TimeTaskBean timeTaskBean=new TimeTaskBean();
    protected Map<String,Object> params=new HashMap<String,Object>();


    private TimeTaskBuilder(String taskCode,String taskName) {
        timeTaskBean.setTaskCode(taskCode);
        timeTaskBean.setTaskName(taskName);
        timeTaskBean.setCreateTime(new Date().getTime());
        timeTaskBean.setTaskStatus(TaskStatus.wait);
    }



    /**
     * 添加执行参数
     * @param key 参数键
     * @param val 参数值
     * @return
     */
    public TimeTaskBuilder addParam(String key,Object val){
        params.put(key, val);
        return this;
    }
    /**
     * 批量添加执行参数
     * @param params 参数Map
     * @return
     */
    public TimeTaskBuilder addParams(Map<String,Object> params){
        params.putAll(params);
        return this;
    }

    /**
     * 添加任务执行时间
     * @param execTime
     * @return
     */
    public TimeTaskBuilder execTime(Long execTime){
        timeTaskBean.setExecTime(execTime);
        return this;
    }

    /**
     * 创建任务bean
     * @return
     */
    public TimeTaskBean createTimeTaskBean(){
        timeTaskBean.setParams(JSON.toJSONString(params));
        return timeTaskBean;
    }




    /**
     * 创建一个定时任务
     * @param taskCode 任务代码
     * @param taskName 任务名称
     * @return
     */
    public static TimeTaskBuilder create(String taskCode,String taskName){
        TimeTaskBuilder builder = new TimeTaskBuilder(taskCode,taskName);
        return builder;
    }


    public static void main(String[] args){

        TimeTaskBean save = TimeTaskBuilder.create("task1", "订单超时处理:sss")
                .addParam("id", 10).execTime(System.currentTimeMillis()).createTimeTaskBean();

    }



}
