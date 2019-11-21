package com.ax.apps.cms.service;

import com.ax.apps.cms.bean.BasePrivilege;
import com.ax.apps.cms.vm.PrivilegeTree;

import java.util.List;

public interface IBasePrivilegeService {

    /**
     * 查询权限树
     * @return
     */
    List<PrivilegeTree> findPrivilegeTree();

    List<BasePrivilege> findByParentId(Long id);

    List<BasePrivilege> findByUserId(long id);

    void saveOrUpdate(BasePrivilege privilege);
}
