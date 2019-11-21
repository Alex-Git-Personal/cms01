package com.ax.apps.cms.web.controller;


import com.ax.apps.cms.bean.BaseRole;
import com.ax.apps.cms.service.IBaseRoleService;
import com.ax.apps.cms.utils.Message;
import com.ax.apps.cms.utils.MessageUtil;
import com.ax.apps.cms.vm.RolePrivilegeVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IBaseRoleService roleService;

    @GetMapping("findAll")
    public Message findAll(){
        return MessageUtil.success("查询成功",roleService.findAll());
    }

    /**
     * 级联查询,包含权限的查询
     * @return
     */
    @GetMapping("cascadePrivilegeFindAll")
    public Message cascadePrivilegeFindAll(){
        return MessageUtil.success("查询成功",roleService.cascadePrivilegeFindAll());
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(BaseRole role){
        roleService.saveOrUpdate(role);
        return MessageUtil.success("更新成功");
    }

    @GetMapping("deleteById")
    public Message deleteById(long id){
        roleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @PostMapping("authorization")
    public Message authorization(RolePrivilegeVM rolePrivilegeVM){

        roleService.authorization(rolePrivilegeVM.getId(),rolePrivilegeVM.getPrivileges());
        return MessageUtil.success("授权成功");
    }
}
