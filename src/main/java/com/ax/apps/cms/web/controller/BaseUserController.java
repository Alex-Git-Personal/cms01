package com.ax.apps.cms.web.controller;


import com.ax.apps.cms.bean.BaseUser;
import com.ax.apps.cms.service.IBaseUserService;
import com.ax.apps.cms.utils.Message;
import com.ax.apps.cms.utils.MessageUtil;
import com.ax.apps.cms.vm.UserRoleVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/baseUser")
public class BaseUserController {

    @Autowired
    private IBaseUserService userService;

    @GetMapping("cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        return MessageUtil.success("查询成功",userService.cascadeRoleFindAll());
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(BaseUser baseUser){
        userService.saveOrUpdate(baseUser);
        return MessageUtil.success("更新成功!!!");
    }
    @PostMapping("setRoles")
    public Message setRoles(UserRoleVM userRoleVM){
        userService.setRoles(userRoleVM.getId(),userRoleVM.getRoles());
        return MessageUtil.success("权限设置成功");
    }

}
