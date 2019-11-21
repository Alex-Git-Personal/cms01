package com.ax.apps.cms.service;

import com.ax.apps.cms.bean.BaseUser;
import com.ax.apps.cms.bean.extend.BaseUserExtend;
import com.ax.apps.cms.vm.UserVM;

import java.util.List;

public interface IBaseUserService {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    BaseUserExtend findById(long id);

    /**
     * 登入功能
     * @param userVM
     * @return
     */
    BaseUser login(UserVM userVM);

    /**
     * 查询所有用户
     * @return
     */
    List<BaseUser> findAll();

    /**
     * 级联角色查询用户
     * @return
     */
    List<BaseUserExtend> cascadeRoleFindAll();

    /**
     * 保存或者修改用户
     * @param user
     */
    void saveOrUpdate(BaseUser user);

    /**
     * 设置权限
     * @param id
     * @param roles
     */
    void setRoles(long id,List<Long> roles);
}
