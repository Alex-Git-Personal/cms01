package com.ax.apps.cms.web.controller;


import com.ax.apps.cms.bean.BasePrivilege;
import com.ax.apps.cms.service.IBasePrivilegeService;
import com.ax.apps.cms.utils.Message;
import com.ax.apps.cms.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private IBasePrivilegeService privilegeService;

    @GetMapping("findPrivilegeTree")
    public Message findPrivilegeTree(){
        return MessageUtil.success("查询成功",privilegeService.findPrivilegeTree());
    }

    @GetMapping("findByParentId")
    public Message findByParentId(Long id){
        return MessageUtil.success("查询成功",privilegeService.findByParentId(id));
    }
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(BasePrivilege privilege){
        privilegeService.saveOrUpdate(privilege);
        return MessageUtil.success("更新成功");
    }
}
