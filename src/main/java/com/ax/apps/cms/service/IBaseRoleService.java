package com.ax.apps.cms.service;

import com.ax.apps.cms.bean.BaseRole;
import com.ax.apps.cms.bean.extend.BaseRoleExtend;

import java.util.List;

public interface IBaseRoleService {
    /**
     * 查询所有
     * @return
     */
    List<BaseRole> findAll();

    /**
     * 级联查询所有的角色和权限
     * @return
     */
    List<BaseRoleExtend> cascadePrivilegeFindAll();

    /**
     * 保存或者修改
     * @param role
     */
    void saveOrUpdate(BaseRole role);

    /**
     * 根据id删除角色
     * @param id
     */
    void deleteById(long id);

    /**
     * 给角色授权
     * @param id
     * @param privileges
     */
    void authorization(long id,List<Long> privileges);
}
