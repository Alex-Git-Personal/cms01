package com.ax.apps.cms.dao.extend;

import com.ax.apps.cms.bean.extend.ArticleExtend;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ArticleMapper扩展的接口
 */
@Repository
public interface ArticleExtendMapper {

    /**
     * 扩展,带有附加表的数据的返回
     * @return
     */
    List<ArticleExtend> selectAll();
    /**
     * 根据id查询文章
     * @return
     */
    ArticleExtend findById(long id);
}
