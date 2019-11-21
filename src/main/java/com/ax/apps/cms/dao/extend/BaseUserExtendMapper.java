package com.ax.apps.cms.dao.extend;

import com.ax.apps.cms.bean.extend.BaseUserExtend;

import java.util.List;

/**
 * 用户表的扩展dao层
 */
public interface BaseUserExtendMapper {

    BaseUserExtend selectById(long id);

    List<BaseUserExtend> selectAll();
}
