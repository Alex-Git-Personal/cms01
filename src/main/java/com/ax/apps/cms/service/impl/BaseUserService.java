package com.ax.apps.cms.service.impl;

import com.ax.apps.cms.bean.BaseUser;
import com.ax.apps.cms.bean.BaseUserExample;
import com.ax.apps.cms.bean.BaseUserRole;
import com.ax.apps.cms.bean.BaseUserRoleExample;
import com.ax.apps.cms.bean.extend.BaseUserExtend;
import com.ax.apps.cms.dao.BaseUserMapper;
import com.ax.apps.cms.dao.BaseUserRoleMapper;
import com.ax.apps.cms.dao.extend.BaseUserExtendMapper;
import com.ax.apps.cms.service.IBaseUserService;
import com.ax.apps.cms.utils.CustomerException;
import com.ax.apps.cms.vm.UserVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class BaseUserService implements IBaseUserService {

    @Resource
    private BaseUserExtendMapper baseUserExtendMapper;
    @Resource
    private BaseUserMapper baseUserMapper;
    @Resource
    private BaseUserRoleMapper baseUserRoleMapper;
    @Override
    public BaseUserExtend findById(long id) {
        //根据token里面的数据查询用户的信息
        return baseUserExtendMapper.selectById(id);
    }

    @Override
    public BaseUser login(UserVM userVM) {
        BaseUserExample example=new BaseUserExample();
        example.createCriteria().andUsernameEqualTo(userVM.getUsername());
        List<BaseUser> baseUsers = baseUserMapper.selectByExample(example);
        if(baseUsers.size()<1){
            throw new CustomerException("该用户不存在");
        }
        BaseUser baseUser=baseUsers.get(0);
        if (!userVM.getPassword().equals(baseUser.getPassword())){
            throw new CustomerException("密码输入错误");
        }
        return baseUser;
    }

    @Override
    public List<BaseUser> findAll() {

        return null;

    }

    @Override
    public List<BaseUserExtend> cascadeRoleFindAll() {
        return  baseUserExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(BaseUser user) {

        if (user.getId()!=null){
            //修改
            baseUserMapper.updateByPrimaryKey(user);
        }else{
            //保存
            BaseUserExample example=new BaseUserExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername());
            List<BaseUser> baseUsers = baseUserMapper.selectByExample(example);
            if(baseUsers!=null&&baseUsers.size()>0){
                throw new CustomerException("该用户名已经被占用!!!");
            }
            //用户初始化的一些状态
            user.setRegisterTime(new Date().getTime());
            user.setStatus(BaseUserExtend.STATUS_NORMAL);
            baseUserMapper.insert(user);

        }

    }

    /**
     * 用户设置权限
     * @param id
     * @param roles
     */
    @Override
    @Transactional
    public void setRoles(long id, List<Long> roles) {

        BaseUserRoleExample example=new BaseUserRoleExample();
        if (roles==null||roles.size()<1){
            example.createCriteria().andUserIdEqualTo(id);
            baseUserRoleMapper.deleteByExample(example);
            return;
        }
        example.createCriteria().andUserIdEqualTo(id);
        List<BaseUserRole> baseUserRoles = baseUserRoleMapper.selectByExample(example);
        List<Long> oldRoles=new ArrayList<>();
        Iterator<BaseUserRole> iterator = baseUserRoles.iterator();
        while (iterator.hasNext()){
            oldRoles.add(iterator.next().getRoleId());
        }
        //添加上原来没有的权限
        BaseUserRole baseUserRole;
        for (Long role : roles) {
            if (!oldRoles.contains(role)){
                baseUserRole=new BaseUserRole();
                baseUserRole.setRoleId(role);
                baseUserRole.setUserId(id);
                baseUserRoleMapper.insert(baseUserRole);
            }
        }
        //去除取消的权限
        for (BaseUserRole userRole : baseUserRoles) {
            if (!roles.contains(userRole.getRoleId())){
                baseUserRoleMapper.deleteByPrimaryKey(userRole.getId());
            }
        }

    }
}
