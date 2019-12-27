package com.ax.apps.cms.dao.extend;

import com.ax.apps.cms.bean.BaseRole;
import com.ax.apps.cms.bean.extend.BaseRoleExtend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRoleExtendMapper {
    /**
     * 查询角色根据用户的id
     * @param id
     * @return
     */
    List<BaseRole> selectByUserId(long id);

    /**
     * 级联查询
     * @return
     */
    List<BaseRoleExtend> selectAll();

}
