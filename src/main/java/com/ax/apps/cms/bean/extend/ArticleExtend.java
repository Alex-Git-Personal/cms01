package com.ax.apps.cms.bean.extend;

import com.ax.apps.cms.bean.Article;
import com.ax.apps.cms.bean.Category;
import com.ax.apps.cms.bean.Comment;

import java.util.List;

public class ArticleExtend extends Article {

    public static final String STATUS_UNCHECK="未审核";
    public static final String STATUS_CHECK_PASS="审核通过";
    public static final String STATUS_CHECK_NOPASS="审核未通过";

    /*
        随便加点注释
     */
    private Category category;

    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
