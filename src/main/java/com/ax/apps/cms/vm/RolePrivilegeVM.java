package com.ax.apps.cms.vm;

import java.util.List;

public class RolePrivilegeVM {
    private Long id;
    private List<Long> privileges;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Long> privileges) {
        this.privileges = privileges;
    }
}
