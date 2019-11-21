package com.ax.apps.cms.service.impl;

import com.ax.apps.cms.bean.BaseRole;
import com.ax.apps.cms.bean.BaseRoleExample;
import com.ax.apps.cms.bean.BaseRolePrivilege;
import com.ax.apps.cms.bean.BaseRolePrivilegeExample;
import com.ax.apps.cms.bean.extend.BaseRoleExtend;
import com.ax.apps.cms.dao.BaseRoleMapper;
import com.ax.apps.cms.dao.BaseRolePrivilegeMapper;
import com.ax.apps.cms.dao.extend.BaseRoleExtendMapper;
import com.ax.apps.cms.service.IBaseRoleService;
import com.ax.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BaseRoleService implements IBaseRoleService {

    @Resource
    private BaseRoleMapper roleMapper;

    @Resource
    private BaseRoleExtendMapper roleExtendMapper;

    @Resource
    private BaseRolePrivilegeMapper baseRolePrivilegeMapper;

    @Override
    public List<BaseRole> findAll() {
        BaseRoleExample example=new BaseRoleExample();
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<BaseRoleExtend> cascadePrivilegeFindAll() {

        return roleExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(BaseRole role) {

        if (role.getId()!=null){
            //修改
            roleMapper.updateByPrimaryKey(role);
        }else{
            //保存
            BaseRoleExample example=new BaseRoleExample();
            example.createCriteria().andNameEqualTo(role.getName());
            List<BaseRole> baseRoles = roleMapper.selectByExample(example);
            if (baseRoles!=null&&baseRoles.size()>0){
                throw new CustomerException("角色名不可以重名");
            }
            roleMapper.insert(role);
        }
    }

    @Override
    public void deleteById(long id) {
        BaseRoleExample example=new BaseRoleExample();
        example.createCriteria().andIdEqualTo(id);
        List<BaseRole> baseRoles = roleMapper.selectByExample(example);
        if (baseRoles==null||baseRoles.size()<1){
            throw new CustomerException("要删除的角色不存在");
        }
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void authorization(long id, List<Long> privileges) {
        BaseRolePrivilegeExample example=new BaseRolePrivilegeExample();
        if (privileges==null||privileges.size()<1){
            example.createCriteria().andRoleIdEqualTo(id);
            baseRolePrivilegeMapper.deleteByExample(example);
            return;
        }
        example.createCriteria().andRoleIdEqualTo(id);
        List<BaseRolePrivilege> baseRolePrivileges = baseRolePrivilegeMapper.selectByExample(example);
        List<Long> oldPrivileges=new ArrayList<>();
        Iterator<BaseRolePrivilege> iterator = baseRolePrivileges.iterator();
        while (iterator.hasNext()){
            oldPrivileges.add(iterator.next().getPrivilegeId());
        }
        //添加新的权限
        BaseRolePrivilege baseRolePrivilege;
        for (Long privilege : privileges) {
            if (!oldPrivileges.contains(privilege)){
                baseRolePrivilege=new BaseRolePrivilege();
                baseRolePrivilege.setPrivilegeId(privilege);
                baseRolePrivilege.setRoleId(id);
                baseRolePrivilegeMapper.insert(baseRolePrivilege);
            }
        }

        for (BaseRolePrivilege rolePrivilege : baseRolePrivileges) {
            if (!privileges.contains(rolePrivilege.getPrivilegeId())){
                baseRolePrivilegeMapper.deleteByPrimaryKey(rolePrivilege.getId());
            }
        }

    }
}
