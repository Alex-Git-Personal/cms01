package com.ax.apps.cms.dao.extend;

import com.ax.apps.cms.bean.extend.BaseUserExtend;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表的扩展dao层
 */
@Repository
public interface BaseUserExtendMapper {

    BaseUserExtend selectById(long id);

    List<BaseUserExtend> selectAll();
}
