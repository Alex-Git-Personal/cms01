package com.ax.apps.cms.service;

import com.ax.apps.cms.bean.Article;
import com.ax.apps.cms.bean.extend.ArticleExtend;

import java.util.List;

/**
 * 文章业务层
 */
public interface IArticleService {
    /**
     * 查询所有文章
     * @return
     */
    List<Article> findAll();

    /**
     * 查询所有文章,和分类
     * @return
     */
    List<ArticleExtend> cascadeFindAll();

    /**
     * 查询所有的文章,包括评论
     * @return
     */
    ArticleExtend findById(long id);

    /**
     * 增删改
     * @param article
     */
    void saveOrUpdate(Article article);
}
