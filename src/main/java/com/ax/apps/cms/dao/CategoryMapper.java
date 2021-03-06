package com.ax.apps.cms.dao;

import com.ax.apps.cms.bean.Category;
import com.ax.apps.cms.bean.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    long countByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    int deleteByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    int insert(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    int insertSelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    List<Category> selectByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    Category selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Thu Nov 14 09:56:27 CST 2019
     */
    int updateByPrimaryKey(Category record);
}