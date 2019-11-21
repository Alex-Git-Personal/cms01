package com.ax.apps.cms.dao.extend;

import com.ax.apps.cms.bean.Comment;

import java.util.List;

public interface CommentExtendMapper {

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    List<Comment> selectByArticleId(long id);
}