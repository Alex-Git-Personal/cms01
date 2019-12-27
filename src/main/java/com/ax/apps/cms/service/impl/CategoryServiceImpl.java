package com.ax.apps.cms.service.impl;

import com.ax.apps.cms.bean.Category;
import com.ax.apps.cms.bean.CategoryExample;
import com.ax.apps.cms.dao.CategoryMapper;
import com.ax.apps.cms.service.ICategoryService;
import com.ax.apps.cms.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void deleteById(long id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category==null){
            throw new CustomerException("你删除的栏目不存在");
        }
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Category> findAll() {

        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public void saveOrUpdate(Category category) {
        if(category.getId()!=null){
            categoryMapper.updateByPrimaryKey(category);
        }else{
            CategoryExample example=new CategoryExample();
            example.createCriteria().andNameEqualTo(category.getName());
            List<Category> categories = categoryMapper.selectByExample(example);
            if (categories.size()>0){
                throw new CustomerException("栏目的名称不能相同");
            }
            categoryMapper.insert(category);
        }
    }

    @Override
    @Transactional
    public void batchDelete(long[] ids) {
        for (long id : ids) {
            deleteById(id);
        }
    }
}
