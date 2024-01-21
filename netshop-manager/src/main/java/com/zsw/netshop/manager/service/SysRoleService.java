package com.zsw.netshop.manager.service;

import com.github.pagehelper.PageInfo;
import com.zsw.netshop.model.dto.system.SysRoleDto;
import com.zsw.netshop.model.entity.system.SysRole;

public interface SysRoleService {

    //角色列表的方法
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit);

    //2.角色添加的方法
    void saveSysRole(SysRole sysRole);
}
