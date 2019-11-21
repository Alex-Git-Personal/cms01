package com.ax.apps.cms.service;

import com.ax.apps.cms.bean.Category;

import java.util.List;

/**
 * 栏目的业务层接口
 */
public interface ICategoryService {
    /**
     * 根据id删除
     * @param id
     */
    void deleteById(long id);

    /**
     * 查询所有
     * @return
     */
    List<Category> findAll();

    /**
     * 保存或者更新栏目
     * @param category
     */
    void saveOrUpdate(Category category);

    /**
     * 批量删除
     * @param ids
     */
    void batchDelete(long[] ids);

}
