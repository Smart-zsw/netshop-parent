package com.zsw.netshop.manager.service;

import com.zsw.netshop.model.entity.system.SysMenu;

import java.util.List;

public interface SysMenuService {

    //菜单列表
    List<SysMenu> findNodes();
}
