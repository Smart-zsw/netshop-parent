package com.zsw.netshop.manager.service.impl;

import com.zsw.netshop.manager.mapper.SysRoleMenuMapper;
import com.zsw.netshop.manager.service.SysMenuService;
import com.zsw.netshop.manager.service.SysRoleMenuService;
import com.zsw.netshop.model.dto.system.AssginMenuDto;
import com.zsw.netshop.model.entity.system.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private SysMenuService sysMenuService;

    //1 查询所有菜单 和 查询角色分配过菜单id列表
    @Override
    public Map<String, Object> findSysRoleMenuByRoleId(Long roleId) {
        //查询所有菜单
        List<SysMenu> sysMenuList = sysMenuService.findNodes();

        //查询角色分配过菜单id列表
        List<Long> roleMenuIds = sysRoleMenuMapper.findSysRoleMenuByRoleId(roleId);

        Map<String,Object> map = new HashMap<>();
        map.put("sysMenuList",sysMenuList);
        map.put("roleMenuIds",roleMenuIds);
        return map;
    }

    //分配角色菜单
    @Override
    public void doAssign(AssginMenuDto assginMenuDto) {
        //删除角色分配菜单数据
        sysRoleMenuMapper.deleteByRoleId(assginMenuDto.getRoleId());

        //保存角色分配数据
        List<Map<String, Number>> menuInfo = assginMenuDto.getMenuIdList();
        if (menuInfo != null && menuInfo.size()>0) {//角色分配了菜单
            sysRoleMenuMapper.doAssign(assginMenuDto);
        }
    }
}
