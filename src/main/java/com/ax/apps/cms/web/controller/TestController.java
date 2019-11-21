package com.ax.apps.cms.web.controller;


import com.ax.apps.cms.bean.Test;
import com.ax.apps.cms.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试Controller层
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;
//    @RequestMapping("/findAll")
    @GetMapping("/findAll")
    public List<Test> findAll(){
        return testService.findAll();
    }
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(Test test){

        testService.saveOrUpdate(test);
        return "保存成功!!!";
    }
}
