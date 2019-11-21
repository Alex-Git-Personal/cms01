package com.ax.apps.cms.vm;

import com.ax.apps.cms.bean.BasePrivilege;

import java.util.List;

/**
 * 查询权限树
 */
public class PrivilegeTree extends BasePrivilege {
    private List<BasePrivilege> children;

    public List<BasePrivilege> getChildren() {
        return children;
    }

    public void setChildren(List<BasePrivilege> children) {
        this.children = children;
    }
}
