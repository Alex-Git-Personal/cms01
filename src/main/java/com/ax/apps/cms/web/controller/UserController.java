package com.ax.apps.cms.web.controller;


import com.ax.apps.cms.bean.BaseUser;
import com.ax.apps.cms.bean.extend.BaseUserExtend;
import com.ax.apps.cms.service.IBaseUserService;
import com.ax.apps.cms.utils.JwtTokenUtil;
import com.ax.apps.cms.utils.Message;
import com.ax.apps.cms.utils.MessageUtil;
import com.ax.apps.cms.vm.UserVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IBaseUserService userService;
    @PostMapping("login")
    public Message login(@RequestBody UserVM userVM){
        //登入验证
        BaseUser user = userService.login(userVM);
        //将用户相关的数据信息存放到token中
        String token = JwtTokenUtil.createJWT(user.getId(), user.getUsername());

        Map<String,String> map=new HashMap<>();
        map.put("token",token);
        return MessageUtil.success("登入成功",map);
    }

    @ApiOperation("通过token获取用户的信息")
    @GetMapping("info")
    public Message info(String token){

        long id=Long.parseLong(JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret));
        BaseUserExtend baseUserExtend = userService.findById(id);
        return MessageUtil.success("查询用户信息",baseUserExtend);
    }

    @PostMapping("logout")
    public Message logout(){
        //把token从缓存中删除
        return MessageUtil.success("退出成功");
    }

}
