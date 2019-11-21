package com.ax.apps.cms.bean.extend;

import com.ax.apps.cms.bean.BasePrivilege;
import com.ax.apps.cms.bean.BaseRole;

import java.util.List;

public class BaseRoleExtend extends BaseRole {
    private List<BasePrivilege> privileges;

    /**
     * 添加了第二段注释
     * @return
     */
    public List<BasePrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<BasePrivilege> privileges) {
        this.privileges = privileges;
    }
}
