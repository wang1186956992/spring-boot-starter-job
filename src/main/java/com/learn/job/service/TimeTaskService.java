package com.learn.job.service;

import com.learn.job.entity.TimeTaskBean;

import java.util.List;

/**
 * Created by yf003 on 2017/9/6.
 */
public interface TimeTaskService {

    List<? extends TimeTaskBean> findByTimeTaskBeanList(int pageNo, int pageSize);

    void updateTimeTaskExec(Long id);

    void updateTimeTaskError(Long id, String msg);
}
