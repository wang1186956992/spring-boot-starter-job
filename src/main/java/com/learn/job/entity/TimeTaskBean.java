package com.learn.job.entity;


import com.learn.job.entity.enumType.TaskStatus;

/**
 * 定时任务实体
 */

public class TimeTaskBean {
    private Long id;
    /**
     * 任务代码
     */
    private String taskCode;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务参数，JSON
     */
    private String params;
    /**
     * 计划执行时间
     */
    private Long execTime;
    /**
     * 真正执行时间
     */
    private Long realExecTime;
    /**
     * 创建任务的时间
     */
    private Long createTime;

    /**
     * 任务状态
     */
    private TaskStatus taskStatus;

    /**
     * 错误信息
     */
    private String error;
    /**
     * 创建说明
     */
    private String createInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getExecTime() {
        return execTime;
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    public Long getRealExecTime() {
        return realExecTime;
    }

    public void setRealExecTime(Long realExecTime) {
        this.realExecTime = realExecTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCreateInfo() {
        return createInfo;
    }

    public void setCreateInfo(String createInfo) {
        this.createInfo = createInfo;
    }
}
