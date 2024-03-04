package com.zsw.netshop.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsw.netshop.manager.mapper.SysRoleMapper;
import com.zsw.netshop.manager.service.SysRoleService;
import com.zsw.netshop.model.dto.system.SysRoleDto;
import com.zsw.netshop.model.entity.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    //角色列表的方法
    @Override
    public PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit) {
        //设置分页参数
        PageHelper.startPage(current, limit);
        //根据条件查询所有数据
        List<SysRole> list = sysRoleMapper.findByPage(sysRoleDto);
        //封装pageInfo对象
        return new PageInfo<>(list);
    }

    //2.角色添加的方法
    @Override
    public void saveSysRole(SysRole sysRole) {
        sysRoleMapper.save(sysRole);
    }

    //3.角色修改的方法
    @Override
    public void updateSysRole(SysRole sysRole) {
        sysRoleMapper.update(sysRole);
    }

    //4.角色删除的方法
    @Override
    public void deleteById(Long roleId) {
        sysRoleMapper.delete(roleId);
    }

    //查询所有角色
    @Override
    public Map<String, Object> findAll() {
        //1 查询所有角色
        List<SysRole> roleList = sysRoleMapper.findAll();

        //TODO 2 分配过的角色列表
        Map<String,Object> map = new HashMap<>();
        map.put("allRolesList",roleList);

        return map;
    }
}
