package com.ax.apps.cms.dao;

import com.ax.apps.cms.bean.BaseRolePrivilege;
import com.ax.apps.cms.bean.BaseRolePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRolePrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    long countByExample(BaseRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    int deleteByExample(BaseRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    int insert(BaseRolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    int insertSelective(BaseRolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    List<BaseRolePrivilege> selectByExample(BaseRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    BaseRolePrivilege selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    int updateByExampleSelective(@Param("record") BaseRolePrivilege record, @Param("example") BaseRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    int updateByExample(@Param("record") BaseRolePrivilege record, @Param("example") BaseRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    int updateByPrimaryKeySelective(BaseRolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Mon Nov 18 19:54:52 CST 2019
     */
    int updateByPrimaryKey(BaseRolePrivilege record);
}