package com.ax.apps.cms.service.impl;

import com.ax.apps.cms.bean.Test;
import com.ax.apps.cms.bean.TestExample;
import com.ax.apps.cms.dao.TestMapper;
import com.ax.apps.cms.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("testService")
public class TestServiceImpl implements ITestService {

    @Resource
    private TestMapper testMapper;
    @Override
    public void saveOrUpdate(Test test) {
        if (test.getId()!=null){
            testMapper.updateByPrimaryKey(test);
        }else {
            testMapper.insert(test);
        }
    }

    @Override
    public List<Test> findAll() {
        TestExample example=new TestExample();
        return testMapper.selectByExample(example);
    }
}
