package com.ax.apps.cms.service;

import com.ax.apps.cms.bean.Test;

import java.util.List;

/**
 * test业务层接口
 */
public interface ITestService {
    /**
     * 修改或者保存
     */
    void saveOrUpdate(Test test);

    /**
     * 查询所有
     * @return
     */
    List<Test> findAll();

}
