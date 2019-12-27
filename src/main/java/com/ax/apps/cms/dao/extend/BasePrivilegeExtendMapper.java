package com.ax.apps.cms.dao.extend;

import com.ax.apps.cms.bean.BasePrivilege;
import com.ax.apps.cms.vm.PrivilegeTree;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasePrivilegeExtendMapper {

    List<BasePrivilege> selectByRoleId(long id);

    /**
     * 查询权限树
     * @return
     */
    List<PrivilegeTree> selectAll();

    List<BasePrivilege> selectByParentId(long id);

    List<BasePrivilege> selectByUserId(long id);
}
