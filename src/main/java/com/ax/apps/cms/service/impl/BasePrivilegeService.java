package com.ax.apps.cms.service.impl;

import com.ax.apps.cms.bean.BasePrivilege;
import com.ax.apps.cms.bean.BasePrivilegeExample;
import com.ax.apps.cms.dao.BasePrivilegeMapper;
import com.ax.apps.cms.dao.extend.BasePrivilegeExtendMapper;
import com.ax.apps.cms.service.IBasePrivilegeService;
import com.ax.apps.cms.utils.CustomerException;
import com.ax.apps.cms.vm.PrivilegeTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BasePrivilegeService implements IBasePrivilegeService {

    @Resource
    private BasePrivilegeExtendMapper privilegeExtendMapper;

    @Resource
    private BasePrivilegeMapper privilegeMapper;
    @Override
    public List<PrivilegeTree> findPrivilegeTree() {

        return privilegeExtendMapper.selectAll();
    }

    @Override
    public List<BasePrivilege> findByParentId(Long id) {
        BasePrivilegeExample example=new BasePrivilegeExample();
        if (id==null){
            example.createCriteria().andParentIdIsNull();
        }else{
            example.createCriteria().andParentIdEqualTo(id);
        }
        return privilegeMapper.selectByExample(example);
    }

    @Override
    public List<BasePrivilege> findByUserId(long id) {

        return privilegeExtendMapper.selectByUserId(id);
    }

    @Override
    public void saveOrUpdate(BasePrivilege privilege) {
        if (privilege.getId()!=null){
            privilegeMapper.updateByPrimaryKey(privilege);
        }else{
            BasePrivilegeExample example=new BasePrivilegeExample();
            example.createCriteria().andNameEqualTo(privilege.getName());
            List<BasePrivilege> basePrivileges = privilegeMapper.selectByExample(example);
            if (basePrivileges!=null&&basePrivileges.size()>0){
                throw new CustomerException("权限名称不可以重复");
            }
            privilegeMapper.insert(privilege);
        }
    }

}
