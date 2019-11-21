package com.ax.apps.cms.service.impl;

import com.ax.apps.cms.bean.Article;
import com.ax.apps.cms.bean.ArticleExample;
import com.ax.apps.cms.bean.extend.ArticleExtend;
import com.ax.apps.cms.dao.ArticleMapper;
import com.ax.apps.cms.dao.extend.ArticleExtendMapper;
import com.ax.apps.cms.service.IArticleService;
import com.ax.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private ArticleExtendMapper articleExtendMapper;

    @Override
    public List<Article> findAll() {

        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public List<ArticleExtend> cascadeFindAll() {

        return articleExtendMapper.selectAll();
    }

    @Override
    public ArticleExtend findById(long id) {
        return articleExtendMapper.findById(id);
    }

    @Override
    public void saveOrUpdate(Article article) {
        if (article.getId()!=null){
            articleMapper.updateByPrimaryKey(article);
        }else{
            //标题不能重复
            ArticleExample example =new ArticleExample();
            example.createCriteria().andTitleEqualTo(article.getTitle());

            List<Article> articles=articleMapper.selectByExample(example);

            if(articles.size()>0){
                throw new CustomerException("标题不能重复!!!");
            }
            article.setPublishTime(new Date().getTime());
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            article.setThumpUp(0l);
            article.setThumpDown(0l);
            articleMapper.insert(article);
        }
    }
}
